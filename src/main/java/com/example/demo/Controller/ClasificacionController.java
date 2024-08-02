package com.example.demo.Controller;

import com.example.demo.Models.Clasificacion;
import com.example.demo.Repository.ClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificacion")
public class ClasificacionController {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @GetMapping
    public List<Clasificacion> getAll() {
        return clasificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> findByPk(@PathVariable int id) {
        return clasificacionRepository.findById((long) id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clasificacion save(@RequestBody Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }
}
