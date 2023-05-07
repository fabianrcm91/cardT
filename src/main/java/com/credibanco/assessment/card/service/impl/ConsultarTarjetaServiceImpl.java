package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.api.client.TarjetaClient;
import com.credibanco.assessment.card.controller.ConsultarTarjetaController;
import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.dto.TarjetaResponse;
import com.credibanco.assessment.card.mapper.TarjetaMapper;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.service.ConsultarTarjetaService;
import com.credibanco.assessment.card.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultarTarjetaServiceImpl implements ConsultarTarjetaService  {

    @Autowired
    private TarjetaClient client;
    @Autowired
    private TarjetaMapper tarjetaMapper;

    @Override
    public TarjetaResponse consultarTarjeta(Long pan){
        Tarjeta tarjeta=client.findByPAN(pan);
        return TarjetaResponse.builder().pan(Utils.enmascararPan(pan)).titular(tarjeta.getTitular())
                .cedula(tarjeta.getCedula()).telefono(tarjeta.getTelefono()).estado(tarjeta.getEstado()).build();

    }

}
