package com.Logistica.AppLogistica.logica.GestionOrden;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends MongoRepository<Orden, String> {
    // Se puede agregar métodos personalizados aquí si es necesario
}