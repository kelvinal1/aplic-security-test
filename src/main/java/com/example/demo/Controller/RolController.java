package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findByPk(@PathVariable int id) {
        return rolRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol save(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable int id, @RequestBody Rol rolDetails) {
        return rolRepository.findById(id)
                .map(rol -> {
                    rol.setRol(rolDetails.getRol());
                    rol.setEstado(rolDetails.isEstado());
                    Rol updatedRol = rolRepository.save(rol);
                    return ResponseEntity.ok(updatedRol);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
