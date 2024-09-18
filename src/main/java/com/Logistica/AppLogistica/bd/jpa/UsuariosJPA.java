package com.Logistica.AppLogistica.bd.jpa;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Logistica.AppLogistica.bd.orm.UsuariosORM;

@Repository
public interface UsuariosJPA extends MongoRepository<UsuariosORM,ObjectId> {
}
