package com.example.demo.Controller;

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
        return competenciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competencia save(@RequestBody Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> update(@PathVariable int id, @RequestBody Competencia competenciaDetails) {
        return competenciaRepository.findById(id)
                .map(competencia -> {
                    competencia.setNombre(competenciaDetails.getNombre());
                    competencia.setDescripcion(competenciaDetails.getDescripcion());
                    Competencia updatedCompetencia = competenciaRepository.save(competencia);
                    return ResponseEntity.ok(updatedCompetencia);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
