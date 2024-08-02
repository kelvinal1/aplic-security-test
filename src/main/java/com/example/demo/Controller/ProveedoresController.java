package com.example.demo.Controller;

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
        return proveedoresRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedores save(@RequestBody Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> update(@PathVariable int id, @RequestBody Proveedores proveedoresDetails) {
        return proveedoresRepository.findById(id)
                .map(proveedores -> {
                    proveedores.setRuc(proveedoresDetails.getRuc());
                    proveedores.setTelefono(proveedoresDetails.getTelefono());
                    proveedores.setPais(proveedoresDetails.getPais());
                    proveedores.setDireccion(proveedoresDetails.getDireccion());
                    proveedores.setMoneda(proveedoresDetails.getMoneda());
                    Proveedores updatedProveedores = proveedoresRepository.save(proveedores);
                    return ResponseEntity.ok(updatedProveedores);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
