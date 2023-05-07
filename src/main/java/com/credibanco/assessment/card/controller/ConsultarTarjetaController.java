package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.dto.TarjetaResponse;
import com.credibanco.assessment.card.service.ConsultarTarjetaService;
import com.credibanco.assessment.card.service.CrearTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ConsultarTarjetaController {
    @Autowired
    public ConsultarTarjetaService consultarTarjetaService;

    @GetMapping("/consultartarjeta")
    public TarjetaResponse consultarTarjeta (@RequestParam("pan")Long pan)throws Exception{

        TarjetaResponse result = consultarTarjetaService.consultarTarjeta(pan);

        return result;

    }
}
