package com.macario.MacarioApp.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "boletas")
public class BoletaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_boleta;
    

    private String numero;
    private LocalDate fechaEmision;
    private BigDecimal total;
    private LocalDate fecha;
    private LocalTime hora;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private PedidoModel pedido;


    //getters 
    public Integer getIdBoleta() {
        return id_boleta;
    }
  
    public String getNumero() {
        return numero;
    }
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public PedidoModel getPedido() {
        return pedido;
    }

    public LocalTime getHora() {
        return hora;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    //setters
    public void setIdBoleta(Integer id_boleta) {
        this.id_boleta = id_boleta;
    }
  
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }
    
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
