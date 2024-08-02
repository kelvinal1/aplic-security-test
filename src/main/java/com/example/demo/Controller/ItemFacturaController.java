package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemfactura")
public class ItemFacturaController {

    @Autowired
    private ItemFacturaRepository itemFacturaRepository;

    @GetMapping
    public List<ItemFactura> getAll() {
        return itemFacturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFactura> findByPk(@PathVariable int id) {
        return itemFacturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ItemFactura save(@RequestBody ItemFactura itemFactura) {
        return itemFacturaRepository.save(itemFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemFactura> update(@PathVariable int id, @RequestBody ItemFactura itemFacturaDetails) {
        return itemFacturaRepository.findById(id)
                .map(itemFactura -> {
                    itemFactura.setIdFactura(itemFacturaDetails.getIdFactura());
                    itemFactura.setIdProducto(itemFacturaDetails.getIdProducto());
                    itemFactura.setCantidad(itemFacturaDetails.getCantidad());
                    itemFactura.setPrecio(itemFacturaDetails.getPrecio());
                    itemFactura.setSubtotal(itemFacturaDetails.getSubtotal());
                    ItemFactura updatedItemFactura = itemFacturaRepository.save(itemFactura);
                    return ResponseEntity.ok(updatedItemFactura);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
