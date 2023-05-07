package com.credibanco.assessment.card.service;

import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.dto.TarjetaResponse;

public interface ConsultarTarjetaService {
    TarjetaResponse consultarTarjeta(Long pan);
}
