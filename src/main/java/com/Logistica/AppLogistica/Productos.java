package com.Logistica.AppLogistica;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {
    @Id
    private ObjectId _id;
    
    private int id_producto;
    private String nombre_producto;
    private String descripcion;
    private int cantidad;
    private double precio;
    private int id_categoria;

}
