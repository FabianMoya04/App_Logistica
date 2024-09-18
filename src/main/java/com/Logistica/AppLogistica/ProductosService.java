package com.Logistica.AppLogistica;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    @Autowired
    private ProductosJPA productosJPA;

    public List<Productos> getAllProductos() {
        return productosJPA.findAll();
    }

    public Productos saveProducto(Productos producto) {
        return productosJPA.save(producto);
    }

    public Optional<Productos> obtenerProductoPorId(int id_producto) {
        return productosJPA.findByIdProducto(id_producto);
    }

    public void eliminarProductoPorId(int id_producto) {
        productosJPA.deleteByIdProducto(id_producto);
    }

}
