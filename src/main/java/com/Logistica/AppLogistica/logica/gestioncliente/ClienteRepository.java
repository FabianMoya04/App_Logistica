package com.Logistica.AppLogistica.logica.gestioncliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    // Se puede agregar métodos personalizados aquí si es necesario
}