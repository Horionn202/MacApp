package com.macario.MacarioApp.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Adicional")
public class AdicionalModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id_adicional;

    private String nombre;
    private double precio;
    private String cantidad;

   
    // Getters
    public Integer getId_adicional() {
        return id_adicional;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCantidad() {
        return cantidad;
    }
    
    // Setters
    public void setId_adicional(Integer id_adicional) {
        this.id_adicional = id_adicional;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    





}
