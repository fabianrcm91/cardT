package com.credibanco.assessment.card.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarjetaResponse {
    private String pan;

    private String titular;

    private Long cedula;

    private Long telefono;

    private String estado;

}
