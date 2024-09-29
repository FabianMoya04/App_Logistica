package com.Logistica.AppLogistica.logica.gestionproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoORM> listar() {
        return productoService.listarProductos();
    }

    @PostMapping
    public ResponseEntity<ProductoORM> agregar(@RequestBody ProductoORM producto) {
        ProductoORM nuevoProducto = productoService.agregarProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<ProductoORM> buscar(@RequestParam String nombre) {
        return productoService.buscarProducto(nombre);
    }
}