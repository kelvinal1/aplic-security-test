package com.example.demo.Models;

import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private LocalDate fecha;
    private double descuento;
    private double total;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @OneToMany(mappedBy = "factura")
    private List<ItemFactura> itemsFactura;
}
