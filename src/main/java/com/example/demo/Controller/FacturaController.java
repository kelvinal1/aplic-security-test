package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> getAll() {
        return facturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findByPk(@PathVariable int id) {
        return facturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Factura save(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable int id, @RequestBody Factura facturaDetails) {
        return facturaRepository.findById(id)
                .map(factura -> {
                    factura.setRuc(facturaDetails.getRuc());
                    factura.setIdPersona(facturaDetails.getIdPersona());
                    factura.setFecha(facturaDetails.getFecha());
                    factura.setIdTipoPago(facturaDetails.getIdTipoPago());
                    factura.setDescuento(facturaDetails.getDescuento());
                    factura.setTotal(facturaDetails.getTotal());
                    Factura updatedFactura = facturaRepository.save(factura);
                    return ResponseEntity.ok(updatedFactura);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
