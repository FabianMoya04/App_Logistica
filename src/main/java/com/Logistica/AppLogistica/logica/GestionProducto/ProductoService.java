package com.Logistica.AppLogistica.logica.GestionProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto editarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarProducto(String nombre) {
        return productoRepository.findByNombreProductoContaining(nombre);
    }

    public List<Producto> listarProductosPorCategoria(String idCategoria) {
        return productoRepository.findByIdCategoria(idCategoria);
    }
}