package com.Logistica.AppLogistica;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

    @Id
    private ObjectId _id;

    private int id;

    private String nombre_completo;

    private String email;

    private String password;

    private Date fecha_registro;
    
}
