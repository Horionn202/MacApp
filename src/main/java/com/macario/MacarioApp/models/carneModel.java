package com.macario.MacarioApp.models;


import jakarta.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "Carne")
public class CarneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_carne;

    private String nombre;
    private String descripcion;
    private Integer cantidad;
    @Column(precision = 38, scale = 2)
    private BigDecimal precio;

    @ManyToMany(mappedBy = "carnes")
private java.util.List<PedidoModel> pedidos;


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

    public BigDecimal getPrecio() {
        return precio;
    }
    public java.util.List<PedidoModel> getPedidos() {
        return pedidos;
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

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public void setPedidos(java.util.List<PedidoModel> pedidos) {
        this.pedidos = pedidos;
    }
}
