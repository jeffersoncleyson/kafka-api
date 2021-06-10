package br.com.sensedia.service;

import br.com.sensedia.config.ApplicationEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafka {

    private Logger logger = LoggerFactory.getLogger(ProducerKafka.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ApplicationEnvironment applicationEnvironment;

    public void sendMessage(String message) {
        this.logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(applicationEnvironment.getTopicProducer(), message);
    }
}
