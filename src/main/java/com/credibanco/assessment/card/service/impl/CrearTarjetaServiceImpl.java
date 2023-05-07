package com.credibanco.assessment.card.service.impl;

import com.credibanco.assessment.card.api.client.TarjetaClient;
import com.credibanco.assessment.card.dto.EnrolarTarjetaResponse;
import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.mapper.TarjetaMapper;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.service.CrearTarjetaService;
import com.credibanco.assessment.card.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearTarjetaServiceImpl implements CrearTarjetaService {

    @Autowired
    private TarjetaClient client;

    @Autowired
    private TarjetaMapper tarjetaMapper;

    @Override
    public EnrolarTarjetaResponse crearTarjeta(TarjetaDto tarjetaDto) {

        Tarjeta tarjetaConsultada =client.findByPAN(tarjetaDto.getPan());
        if(tarjetaConsultada== null) {
            Tarjeta tarjeta = tarjetaMapper.dtoEntity(tarjetaDto);
            tarjeta.setId(tarjeta.getId());
            tarjeta.setPan(tarjeta.getPan());
            tarjeta.setTitular(tarjeta.getTitular().toLowerCase());
            tarjeta.setCedula(tarjeta.getCedula());
            tarjeta.setEstado("CREADA");
            var numero = (int) (Math.random() * 100) + 1;
            System.out.println(numero);
            tarjeta.setNumeroValidacion((long) numero);
            tarjeta.setTelefono(tarjeta.getTelefono());
            tarjeta.setTipo(tarjeta.getTipo().toLowerCase());

            try {
            TarjetaDto tarjetaCreada =tarjetaMapper.entityToDto(tarjeta);
            client.save(tarjeta);
                return EnrolarTarjetaResponse.builder().codRespuesta("00").message("Exito").pan(Utils.enmascararPan(tarjeta.getPan()))
                    .numeroValidacion(tarjeta.getNumeroValidacion()).build();
        }catch (Exception exception){

            }
        } else{
            return EnrolarTarjetaResponse.builder().codRespuesta("01").message("Fallido").pan(Utils.enmascararPan(tarjetaDto.getPan())).build();
        }

        return null;
    }

}
