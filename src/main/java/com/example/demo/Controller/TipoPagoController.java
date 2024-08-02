package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @GetMapping
    public List<TipoPago> getAll() {
        return tipoPagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPago> findByPk(@PathVariable int id) {
        return tipoPagoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoPago save(@RequestBody TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPago> update(@PathVariable int id, @RequestBody TipoPago tipoPagoDetails) {
        return tipoPagoRepository.findById(id)
                .map(tipoPago -> {
                    tipoPago.setTipo(tipoPagoDetails.getTipo());
                    tipoPago.setDescrip(tipoPagoDetails.getDescrip());
                    TipoPago updatedTipoPago = tipoPagoRepository.save(tipoPago);
                    return ResponseEntity.ok(updatedTipoPago);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
