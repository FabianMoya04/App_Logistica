package com.Logistica.AppLogistica.logica.gestioncategoria;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
    Categoria findByNombreCategoria(String nombreCategoria);
}