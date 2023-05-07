package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.api.client.TarjetaClient;
import com.credibanco.assessment.card.dto.EnrolarTarjetaResponse;
import com.credibanco.assessment.card.mapper.TarjetaMapper;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.service.EnrolarTarjetaService;
import com.credibanco.assessment.card.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrolarTarjetaServiceImpl implements EnrolarTarjetaService {
    @Autowired
    private TarjetaClient client;
    @Autowired
    private TarjetaMapper tarjetaMapper;

    @Override
    public EnrolarTarjetaResponse enrrolarTarjeta(Long pan, Long numeroValidacion) {

        Tarjeta tarjetaConsultada =client.findByPAN(pan);
        if(tarjetaConsultada!= null){
            if(tarjetaConsultada.getNumeroValidacion()==numeroValidacion){
                tarjetaConsultada.setEstado("ENROLADA");
                client.save(tarjetaConsultada);
                EnrolarTarjetaResponse response=EnrolarTarjetaResponse.builder()
                    .codRespuesta("00").message("Éxito").pan(Utils.enmascararPan(pan)).build();
                return response;
            }else{
                EnrolarTarjetaResponse response=EnrolarTarjetaResponse.builder()
                    .codRespuesta("02").message("Número de validación inválido").pan(Utils.enmascararPan(pan)).build();
                return response;
            }

        }else{
            EnrolarTarjetaResponse response=EnrolarTarjetaResponse.builder()
                    .codRespuesta("01").message("Tarjeta no existe").pan(Utils.enmascararPan(pan)).build();
            return response;
        }
    }



}
