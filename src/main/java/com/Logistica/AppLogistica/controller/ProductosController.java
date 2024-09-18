package com.Logistica.AppLogistica.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Logistica.AppLogistica.bd.orm.ProductosORM;
import com.Logistica.AppLogistica.logica.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ResponseEntity<List<ProductosORM>> obtenerTodosLosProductos() {
        return new ResponseEntity<>(productosService.getAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity<ProductosORM> obtenerProductoPorId(@PathVariable("id_producto") int id_producto) {
        Optional<ProductosORM> producto = productosService.obtenerProductoPorId(id_producto);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductosORM> crearProducto(@RequestBody ProductosORM producto) {
        return new ResponseEntity<>(productosService.saveProducto(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id_producto") int id_producto) {
        productosService.eliminarProductoPorId(id_producto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
