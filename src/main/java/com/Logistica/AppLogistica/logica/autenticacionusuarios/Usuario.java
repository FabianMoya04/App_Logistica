package com.Logistica.AppLogistica.logica.autenticacionusuarios;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
@Data
public class Usuario {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
}
