package br.com.sensedia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class KafkaMessage {

    private String key;
    private String value;
}
