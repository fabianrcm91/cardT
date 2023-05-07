package com.credibanco.assessment.card.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class EnrolarTarjetaResponse {

    String codRespuesta;
    String pan;
    String message;
    Long numeroValidacion;

}
