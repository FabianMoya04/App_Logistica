package com.Logistica.AppLogistica.logica.gestionproducto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@Data
public class Producto {
    @Id
    private String idProducto;
    private String nombreProducto;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String imagen;
    private String idCategoria;
}