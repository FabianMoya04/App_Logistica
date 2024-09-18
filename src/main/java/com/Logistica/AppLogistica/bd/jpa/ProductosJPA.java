package com.Logistica.AppLogistica.bd.jpa;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Logistica.AppLogistica.bd.orm.ProductosORM;

@Repository
public interface ProductosJPA extends MongoRepository<ProductosORM, ObjectId> {
    Optional<ProductosORM> findByIdProducto(int id_producto);

    void deleteByIdProducto(int id_producto);
}
