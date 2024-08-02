package com.example.demo.Models;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ruc;
    private String telefono;
    private String pais;
    private String correo;
    private String moneda;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
