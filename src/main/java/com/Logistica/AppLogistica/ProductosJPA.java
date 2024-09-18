package com.Logistica.AppLogistica;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosJPA extends MongoRepository<Productos, ObjectId> {
    Optional<Productos> findByIdProducto(int id_producto);

    void deleteByIdProducto(int id_producto);
}
