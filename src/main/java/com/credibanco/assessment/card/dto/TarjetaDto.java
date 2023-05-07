package com.credibanco.assessment.card.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class TarjetaDto {

    private Long id;

    private Long pan;

    private String titular;

    private Long cedula;

    private String tipo;

    private Long telefono;

    private String estado;

    private Long numeroValidacion;
}
