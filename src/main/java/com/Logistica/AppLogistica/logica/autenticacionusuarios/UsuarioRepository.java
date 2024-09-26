package com.Logistica.AppLogistica.logica.autenticacionusuarios;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuariosORM, ObjectId> {
    List<UsuariosORM> findById(int id);
}