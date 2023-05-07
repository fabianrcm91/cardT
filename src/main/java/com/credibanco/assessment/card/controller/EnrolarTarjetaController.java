package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.dto.EnrolarTarjetaResponse;
import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.service.EnrolarTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EnrolarTarjetaController {

    @Autowired
    EnrolarTarjetaService enrolarTarjetaService;
    @PutMapping("/enrolartarjeta")
    public EnrolarTarjetaResponse enrolarTarjeta (@RequestParam("pan")Long pan,
                                                  @RequestParam("numeroValidacion")Long numeroValidacion)throws Exception{

        EnrolarTarjetaResponse result = enrolarTarjetaService.enrrolarTarjeta(pan,numeroValidacion);

        return result;

    }
}
