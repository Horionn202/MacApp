package com.macario.MacarioApp.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private String nombre;
    private double precio;
    private String cantidad;
    private String descripcion;


    // Getters
    public Integer getId_producto() {
        return id_producto;
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
    public String getDescripcion() {
        return descripcion;
    }
    
    // Setters
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
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
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
