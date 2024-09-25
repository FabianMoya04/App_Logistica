package com.Logistica.AppLogistica.logica.gestioncliente;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Data
public class Cliente {
    @Id
    private String id_cliente;
    private String nombre;
    private String correo;
    private String telefono;
}