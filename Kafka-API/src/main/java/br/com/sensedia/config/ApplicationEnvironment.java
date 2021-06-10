package br.com.sensedia.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ApplicationEnvironment {

    @Value("${spring.kafka.consumer.topic}")
    private String topicConsumer = "topic";

    @Value("${spring.kafka.producer.topic}")
    private String topicProducer = "topic";

}
