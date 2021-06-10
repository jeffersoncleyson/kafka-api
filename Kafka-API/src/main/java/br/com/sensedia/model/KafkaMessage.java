package br.com.sensedia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KafkaMessage {

    @Schema(description = "Trafic of system interesting information.",
            example = "ticket:3221", required = true)
    @NotBlank
    private String value;
}
