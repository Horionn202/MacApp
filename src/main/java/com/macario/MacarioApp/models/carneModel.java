package com.macario.MacarioApp.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Carne")
public class carneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_carne;

    private String nombre;
    private String descripcion;
    private Integer cantidad;

    //getters

    public Integer getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId_carne() {
        return id_carne;
    }

    public String getNombre() {
        return nombre;
    }

    //Setters


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_carne(Integer id_carne) {
        this.id_carne = id_carne;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
