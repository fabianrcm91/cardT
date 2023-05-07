package com.credibanco.assessment.card.api.client;

import com.credibanco.assessment.card.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TarjetaClient extends JpaRepository<Tarjeta,Long> {

    @Query(value = "SELECT * FROM tarjetas t WHERE t.pan = :pan", nativeQuery = true)
    Tarjeta findByPAN(@Param("pan") Long pan);



}
