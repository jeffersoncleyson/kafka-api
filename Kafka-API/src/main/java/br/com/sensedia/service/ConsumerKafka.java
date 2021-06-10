package br.com.sensedia.service;

import br.com.sensedia.model.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafka {

    private Logger logger = LoggerFactory.getLogger(ConsumerKafka.class);

    @Autowired
    private QueueMessages queueMessages;

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}")
    public void receiveMessage(String message) {
        this.logger.info(String.format("#### -> Consumed message -> %s", message));
        this.queueMessages.enqueue(new KafkaMessage("key", message));

    }
}
