package com.example.demo.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "factura")
public class FacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;
    @Column(nullable = false)
    private String ruc ;
    @Column(nullable = false)
    private Long id_persona;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private double descuento;
    @Column(nullable = false)
    private double total;
    @OneToOne
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    private TipoPagoModel tipoPagoModel;

    public FacturaModel() {
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoPagoModel getTipoPagoModel() {
        return tipoPagoModel;
    }

    public void setTipoPagoModel(TipoPagoModel tipoPagoModel) {
        this.tipoPagoModel = tipoPagoModel;
    }
}
