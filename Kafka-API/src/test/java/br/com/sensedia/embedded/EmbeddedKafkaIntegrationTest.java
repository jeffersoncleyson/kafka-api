package br.com.sensedia.embedded;

import br.com.sensedia.model.KafkaMessage;
import br.com.sensedia.service.ProducerKafka;
import br.com.sensedia.service.QueueMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class EmbeddedKafkaIntegrationTest {

    @Autowired
    private ProducerKafka producer;

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private QueueMessages queueMessages;

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingSimpleMessage_thenMessageReceived() throws Exception {

        producer.sendMessage("KafkaProducer message sending");

        latch.await(2000, TimeUnit.MILLISECONDS);

        List<KafkaMessage> queue = queueMessages.getQueue();

        assertThat(queue.get(0).getValue(),  containsString("message sending"));
    }
}
