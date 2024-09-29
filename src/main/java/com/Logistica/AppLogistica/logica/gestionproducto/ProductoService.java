package com.Logistica.AppLogistica.logica.gestionproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoORM> listarProductos() {
        return productoRepository.findAll();
    }

    public ProductoORM agregarProducto(ProductoORM producto) {
        return productoRepository.save(producto);
    }

    public ProductoORM editarProducto(ProductoORM producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public List<ProductoORM> buscarProducto(String nombre) {
        return productoRepository.findByNombreProductoContaining(nombre);
    }

    public List<ProductoORM> listarProductosPorCategoria(String idCategoria) {
        return productoRepository.findByIdCategoria(idCategoria);
    }
}