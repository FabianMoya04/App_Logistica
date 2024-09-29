package com.Logistica.AppLogistica.logica.gestionproducto;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductoRepository extends MongoRepository<ProductoORM, String> {
    List<ProductoORM> findByNombreProductoContaining(String nombre);
    List<ProductoORM> findByIdCategoria(String idCategoria);
}