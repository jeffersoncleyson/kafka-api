package br.com.sensedia.controller;

import br.com.sensedia.config.Routers;
import br.com.sensedia.model.KafkaMessage;
import br.com.sensedia.service.ProducerKafka;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Routers.PRODUCER_ROUTE_BASE)
@Tag(name = "Kafka Producer", description = "Endpoint for producing message to broker")
public class KafkaProducerController {

    @Autowired
    private ProducerKafka producerKafka;

    @Operation(summary = "Send message", description = "Send message to kafka broker", tags = { "KafkaMessage" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message delivered"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Message couldn't be delivered")
    })
    @PostMapping(produces = { "application/json"})
    public ResponseEntity<?> produceMessage(@RequestBody KafkaMessage kafkaMessage){
        try {
            producerKafka.sendMessage(kafkaMessage.getValue());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
