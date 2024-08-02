package com.example.demo.Controller;

import com.example.demo.Models.Competencia;
import com.example.demo.Repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @GetMapping
    public List<Competencia> getAll() {
        return competenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> findByPk(@PathVariable int id) {
        return competenciaRepository.findById((long) id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competencia save(@RequestBody Competencia competencia) {
        return competenciaRepository.save(competencia);
    }
}
