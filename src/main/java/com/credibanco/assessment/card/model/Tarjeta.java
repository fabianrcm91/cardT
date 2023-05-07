package com.credibanco.assessment.card.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TARJETAS")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENTARJETAS")
    @SequenceGenerator(name = "SEQUENTARJETAS",sequenceName = "SEQUENTARJETAS", allocationSize = 1)
    @Column(name = "TARJETAID", nullable = false)
    private Long id;

    @Column(name="PAN",nullable = false)
    private Long pan;

    @Column(name="TITULAR",nullable = false)
    private String titular;

    @Column(name="CEDULA",nullable = false)
    private Long cedula;

    @Column(name="TIPO",nullable = false)
    private String tipo;

    @Column(name="TELEFONO",nullable = false)
    private Long telefono;

    @Column(name="ESTADO",nullable = false)
    private String estado;

    @Column(name="NUMEROVALIDACION",nullable = false)
    private Long numeroValidacion;

}
