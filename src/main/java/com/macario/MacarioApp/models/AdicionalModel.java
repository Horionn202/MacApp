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
    private Integer cantidad;

    @ManyToMany(mappedBy = "adicionales")
private java.util.List<PedidoModel> pedidos;

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
    public Integer getCantidad() {
        return cantidad;
    }
    public java.util.List<PedidoModel> getPedidos() {
        return pedidos;
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
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setPedidos(java.util.List<PedidoModel> pedidos) {
        this.pedidos = pedidos;
    }





}
