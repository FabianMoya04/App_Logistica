package com.Logistica.AppLogistica;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosJPA extends MongoRepository<Productos, ObjectId> {

}
