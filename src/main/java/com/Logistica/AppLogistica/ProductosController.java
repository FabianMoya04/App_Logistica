package com.Logistica.AppLogistica;

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

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ResponseEntity<List<Productos>> obtenerTodosLosProductos() {
        return new ResponseEntity<>(productosService.getAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity<Productos> obtenerProductoPorId(@PathVariable("id_producto") int id_producto) {
        Optional<Productos> producto = productosService.obtenerProductoPorId(id_producto);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos producto) {
        return new ResponseEntity<>(productosService.saveProducto(producto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id_producto") int id_producto) {
        productosService.eliminarProductoPorId(id_producto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
