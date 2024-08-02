package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @GetMapping
    public List<Clasificacion> getAll() {
        return clasificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> findByPk(@PathVariable int id) {
        return clasificacionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clasificacion save(@RequestBody Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasificacion> update(@PathVariable int id, @RequestBody Clasificacion clasificacionDetails) {
        return clasificacionRepository.findById(id)
                .map(clasificacion -> {
                    clasificacion.setGrupo(clasificacionDetails.getGrupo());
                    Clasificacion updatedClasificacion = clasificacionRepository.save(clasificacion);
                    return ResponseEntity.ok(updatedClasificacion);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
