package com.example.demo.Models;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "competencia")
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String  descripcion;

    @ManyToMany(mappedBy = "competencias")
    private Set<Rol> roles;

    // Getters y Setters
}
