package com.macario.MacarioApp.models;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Adicional")
public class AdicionalModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id_adicional;

    private String nombre;
    @Column(precision = 38, scale = 2)
    private BigDecimal precio;
    private String cantidad;

   
    // Getters
    public Integer getId_adicional() {
        return id_adicional;
    }
    public String getNombre() {
        return nombre;
    }
    public BigDecimal getPrecio() {
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
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    





}
