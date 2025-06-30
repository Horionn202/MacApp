package com.macario.MacarioApp.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    private LocalDate fecha;
    private LocalTime hora;
    private Integer cantidad;
    private BigDecimal total;

    // --- Carnes ---
    @ManyToMany
    @JoinTable(
        name = "pedido_carne",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_carne")
    )
    private List<CarneModel> carnes;

    @ElementCollection
    @CollectionTable(name = "cantidad_carne", joinColumns = @JoinColumn(name = "id_pedido"))
    @MapKeyColumn(name = "id_carne")
    @Column(name = "cantidad")
    private Map<Integer, Integer> cantidadCarnes;

    // --- Frutas ---
    @ManyToMany
    @JoinTable(
        name = "pedido_fruta",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_fruta")
    )
    private List<FrutaModel> frutas;

    @ElementCollection
    @CollectionTable(name = "cantidad_fruta", joinColumns = @JoinColumn(name = "id_pedido"))
    @MapKeyColumn(name = "id_fruta")
    @Column(name = "cantidad")
    private Map<Integer, Integer> cantidadFrutas;

    // --- Adicionales ---
    @ManyToMany
    @JoinTable(
        name = "pedido_adicional",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_adicional")
    )
    private List<AdicionalModel> adicionales;

    @ElementCollection
    @CollectionTable(name = "cantidad_adicional", joinColumns = @JoinColumn(name = "id_pedido"))
    @MapKeyColumn(name = "id_adicional")
    @Column(name = "cantidad")
    private Map<Integer, Integer> cantidadAdicionales;

    // --- Getters ---
    public Integer getId_pedido() {
        return id_pedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<CarneModel> getCarnes() {
        return carnes;
    }

    public Map<Integer, Integer> getCantidadCarnes() {
        return cantidadCarnes;
    }

    public List<FrutaModel> getFrutas() {
        return frutas;
    }

    public Map<Integer, Integer> getCantidadFrutas() {
        return cantidadFrutas;
    }

    public List<AdicionalModel> getAdicionales() {
        return adicionales;
    }

    public Map<Integer, Integer> getCantidadAdicionales() {
        return cantidadAdicionales;
    }

    // --- Setters ---
    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setCarnes(List<CarneModel> carnes) {
        this.carnes = carnes;
    }

    public void setCantidadCarnes(Map<Integer, Integer> cantidadCarnes) {
        this.cantidadCarnes = cantidadCarnes;
    }

    public void setFrutas(List<FrutaModel> frutas) {
        this.frutas = frutas;
    }

    public void setCantidadFrutas(Map<Integer, Integer> cantidadFrutas) {
        this.cantidadFrutas = cantidadFrutas;
    }

    public void setAdicionales(List<AdicionalModel> adicionales) {
        this.adicionales = adicionales;
    }

    public void setCantidadAdicionales(Map<Integer, Integer> cantidadAdicionales) {
        this.cantidadAdicionales = cantidadAdicionales;
    }
}
