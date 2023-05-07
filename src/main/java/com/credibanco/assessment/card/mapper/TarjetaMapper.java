package com.credibanco.assessment.card.mapper;

import com.credibanco.assessment.card.dto.TarjetaDto;
import com.credibanco.assessment.card.model.Tarjeta;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TarjetaMapper {
    TarjetaDto entityToDto (Tarjeta tarjeta);
    Tarjeta dtoEntity (TarjetaDto dto);
}
