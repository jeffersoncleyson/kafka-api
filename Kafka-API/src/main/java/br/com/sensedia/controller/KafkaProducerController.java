package br.com.sensedia.controller;

import br.com.sensedia.config.Routers;
import br.com.sensedia.service.ProducerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routers.PRODUCER_ROUTE_BASE)
public class KafkaProducerController {

    @Autowired
    private ProducerKafka producerKafka;

    @GetMapping
    public ResponseEntity<?> produceMessage(){
        producerKafka.sendMessage("teste");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
