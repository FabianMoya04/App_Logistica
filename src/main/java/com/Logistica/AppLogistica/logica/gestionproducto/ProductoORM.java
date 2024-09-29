package com.Logistica.AppLogistica.logica.gestionproducto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@Data
public class ProductoORM {

    @Id
    private int _id;
    private String idCategoria;
    private String nombreProducto;
    private String descripcion;
    private int cantidad;
    private double precio;

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}