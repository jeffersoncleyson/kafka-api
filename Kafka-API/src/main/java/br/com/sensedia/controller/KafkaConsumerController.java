package br.com.sensedia.controller;

import br.com.sensedia.config.Routers;
import br.com.sensedia.service.QueueMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routers.CONSUMER_ROUTE_BASE)
public class KafkaConsumerController {

    @Autowired
    private QueueMessages queueMessages;

    @GetMapping
    public ResponseEntity<?> consumerMessage(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(queueMessages.getQueue());
    }

}
