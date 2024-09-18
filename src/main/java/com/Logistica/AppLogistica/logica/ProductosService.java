package com.Logistica.AppLogistica.logica;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Logistica.AppLogistica.bd.jpa.ProductosJPA;
import com.Logistica.AppLogistica.bd.orm.ProductosORM;

@Service
public class ProductosService {

    @Autowired
    private ProductosJPA productosJPA;

    public List<ProductosORM> getAllProductos() {
        return productosJPA.findAll();
    }

    public ProductosORM saveProducto(ProductosORM producto) {
        return productosJPA.save(producto);
    }

    public Optional<ProductosORM> obtenerProductoPorId(int id_producto) {
        return productosJPA.findByIdProducto(id_producto);
    }

    public void eliminarProductoPorId(int id_producto) {
        productosJPA.deleteByIdProducto(id_producto);
    }

}
