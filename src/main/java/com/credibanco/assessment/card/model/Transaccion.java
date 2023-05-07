package com.credibanco.assessment.card.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TRANSACCIONES")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENTRANSACCION")
    @SequenceGenerator(name = "SEQUENTRANSACCION",sequenceName = "SEQUENTRANSACCION", allocationSize = 1)
    @Column(name = "TRANSACCIONID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAN")
    private Tarjeta pan;

    @Column(name="REFERENCIA",nullable = false)
    private Long referencia;

    @Column(name="TOTAL",nullable = false)
    private Long total;

    @Column(name="FECHA",nullable = false)
    private Date fecha;

    @Column(name="ESTADO",nullable = false)
    private String estado;

    @Column(name="DIRECCION",nullable = false)
    private String direccion;


}
