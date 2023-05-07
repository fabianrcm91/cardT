package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.EnrolarTarjetaResponse;
import com.credibanco.assessment.card.dto.TarjetaDto;

public interface EnrolarTarjetaService {

    EnrolarTarjetaResponse enrrolarTarjeta(Long pan, Long numeroValidacion);
}
