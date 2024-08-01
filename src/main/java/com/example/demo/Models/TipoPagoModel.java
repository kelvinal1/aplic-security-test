package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_pago")
public class TipoPagoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_pago;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;
}

