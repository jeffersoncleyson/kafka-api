package br.com.sensedia.controller;

import br.com.sensedia.config.Routers;
import br.com.sensedia.model.KafkaMessage;
import br.com.sensedia.service.QueueMessages;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = Routers.CONSUMER_ROUTE_BASE)
@Tag(name = "Kafka Consumer", description = "Endpoint for consuming message from broker")
public class KafkaConsumerController {

    @Autowired
    private QueueMessages queueMessages;


    @Operation(summary = "Fetch messages from queue", description = "List of messages from kafka broker", tags = { "KafkaMessage" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = KafkaMessage.class)))),
            @ApiResponse(responseCode = "404", description = "Messages not found")
    })
    @GetMapping(produces = { "application/json"})
    public ResponseEntity<?> consumerMessage(){
        List<KafkaMessage> messages = queueMessages.getQueue();
        if(messages != null && !messages.isEmpty())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(messages);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
