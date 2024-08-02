package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findByPk(@PathVariable int id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable int id, @RequestBody Producto productoDetails) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setStock(productoDetails.getStock());
                    producto.setPrecioUnitario(productoDetails.getPrecioUnitario());
                    producto.setUnidad(productoDetails.getUnidad());
                    producto.setIdClasificacion(productoDetails.getIdClasificacion());
                    producto.setIdProveedor(productoDetails.getIdProveedor());
                    producto.setIva(productoDetails.isIva());
                    Producto updatedProducto = productoRepository.save(producto);
                    return ResponseEntity.ok(updatedProducto);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
