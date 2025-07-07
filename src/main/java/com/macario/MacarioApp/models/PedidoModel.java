package com.macario.MacarioApp.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    private LocalDate fecha;
    private LocalTime hora;

    private Integer cantidadCarne;
    private Integer cantidadFruta;
    private Integer cantidadAdicional;

    private BigDecimal total;

    // Relaciones opcionales (nullable)
  @ManyToMany
@JoinTable(
    name = "pedido_carne",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "id_carne")
)
private java.util.List<CarneModel> carnes;

@ManyToMany
@JoinTable(
    name = "pedido_adicional",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "id_adicional")
)
private java.util.List<AdicionalModel> adicionales;

@ManyToMany
@JoinTable(
    name = "pedido_fruta",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "id_fruta")
)
private java.util.List<FrutaModel> frutas;

@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
private BoletaModel boleta;


@ElementCollection
private List<Integer> cantidadesCarnes = new ArrayList<>();

@ElementCollection
private List<Integer> cantidadesFrutas = new ArrayList<>();

@ElementCollection
private List<Integer> cantidadesAdicionales = new ArrayList<>();

    // Getters y setters
    public Integer getId_pedido() { return id_pedido; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public Integer getCantidadCarne() { return cantidadCarne; }
    public Integer getCantidadFruta() { return cantidadFruta; }
    public Integer getCantidadAdicional() { return cantidadAdicional; }
    public BigDecimal getTotal() { return total; }
    public java.util.List<CarneModel> getCarnes() { return carnes; }
    public java.util.List<AdicionalModel> getAdicionales() { return adicionales; }
    public java.util.List<FrutaModel> getFrutas() { return frutas; }
    public List<Integer> getCantidadesCarnes() { return cantidadesCarnes; }
    public List<Integer> getCantidadesFrutas() { return cantidadesFrutas; }
    public List<Integer> getCantidadesAdicionales() { return cantidadesAdicionales; }
    public BoletaModel getBoleta() { return boleta; }
 


    public void setId_pedido(Integer id_pedido) { this.id_pedido = id_pedido; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setCantidadCarne(Integer cantidadCarne) { this.cantidadCarne = cantidadCarne; }
    public void setCantidadFruta(Integer cantidadFruta) { this.cantidadFruta = cantidadFruta; }
    public void setCantidadAdicional(Integer cantidadAdicional) { this.cantidadAdicional = cantidadAdicional; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public void setCarnes(java.util.List<CarneModel> carnes) { this.carnes = carnes;}
    public void setAdicionales(java.util.List<AdicionalModel> adicionales) {this.adicionales = adicionales; }
    public void setFrutas(java.util.List<FrutaModel> frutas) {this.frutas = frutas;}
    
    public void setCantidadesCarnes(List<Integer> cantidadesCarnes) { this.cantidadesCarnes = cantidadesCarnes; }
    public void setCantidadesFrutas(List<Integer> cantidadesFrutas) { this.cantidadesFrutas = cantidadesFrutas; }
    public void setCantidadesAdicionales(List<Integer> cantidadesAdicionales) { this.cantidadesAdicionales = cantidadesAdicionales;}

    public void setBoleta(BoletaModel boleta) { this.boleta = boleta;}

}

