package com.example.demo.Models;
import jakarta.persistence.*;
import  lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name_r;
    private boolean Estatus;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuario> usuarios;

    @ManyToMany
    @JoinTable(
            name = "rol_competencia",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private Set<Competencia> competencias;
}
