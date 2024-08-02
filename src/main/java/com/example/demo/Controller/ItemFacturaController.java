package com.example.demo.Controller;

import com.example.demo.Models.ItemFactura;
import com.example.demo.Repository.ItemFacturaRepository;
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
        return itemFacturaRepository.findById((long) id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ItemFactura save(@RequestBody ItemFactura itemFactura) {
        return itemFacturaRepository.save(itemFactura);
    }

}
