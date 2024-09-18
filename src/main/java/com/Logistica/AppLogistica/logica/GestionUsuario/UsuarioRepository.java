package com.Logistica.AppLogistica.logica.GestionUsuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Se puede agregar métodos personalizados aquí si es necesario
}