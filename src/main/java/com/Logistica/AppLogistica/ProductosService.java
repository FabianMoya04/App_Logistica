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

    public Optional<Productos> getProductoById(ObjectId _id) {
        return productosJPA.findById(_id);
    }

    public Productos saveProducto(Productos producto) {
        return productosJPA.save(producto);
    }

    public void deleteProducto(ObjectId _Id) {
        productosJPA.deleteById(_Id);
    }

}
