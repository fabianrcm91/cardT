package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.EnrolarTarjetaResponse;
import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.dto.TarjetaResponse;
import com.credibanco.assessment.card.model.Tarjeta;
import com.credibanco.assessment.card.service.CrearTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CrearTarjetaController {

    @Autowired
    public CrearTarjetaService crearTarjetaService;


    @PostMapping ("/creartarjeta")
    public EnrolarTarjetaResponse crearCita(@RequestBody TarjetaDto tarjetaDto) throws Exception {
        System.out.println("entre al controlador");
         EnrolarTarjetaResponse response = crearTarjetaService.crearTarjeta(tarjetaDto);
         return response;
    }
}
