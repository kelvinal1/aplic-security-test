package com.example.demo.Controller;

import com.example.demo.Models.Proveedores;
import com.example.demo.Repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @GetMapping
    public List<Proveedores> getAll() {
        return proveedoresRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> findByPk(@PathVariable int id) {
        return proveedoresRepository.findById((long) id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedores save(@RequestBody Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

}
