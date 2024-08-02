package com.example.demo.Controller;

import com.example.demo.Models.Factura;
import com.example.demo.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> getAll() {
        return facturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findByPk(@PathVariable int id) {
        return facturaRepository.findById((long) id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Factura save(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

}
