package com.macario.MacarioApp.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @ManyToMany
    @JoinTable(
        name = "pedido_carne",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_carne")
    )
    private List<CarneModel> carnes;
   
    @ManyToMany
    @JoinTable(
        name = "pedido_fruta",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_fruta")
    )
    private List<FrutaModel> frutas;

    @ManyToMany
    @JoinTable(
        name = "pedido_adicional",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_adicional")
    )
    private List<AdicionalModel> adicionales;


    // Getters

    public Integer getId_pedido() {
        return id_pedido;
    }

    public List<CarneModel> getCarnes() {
        return carnes;
    }

    public List<FrutaModel> getFrutas() {
        return frutas;
    }

    public List<AdicionalModel> getAdicionales() {
        return adicionales;
    }


    // Setters

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setCarnes(List<CarneModel> carnes) {
        this.carnes = carnes;
    }

    public void setFrutas(List<FrutaModel> frutas) {
        this.frutas = frutas;
    }

    public void setAdicionales(List<AdicionalModel> adicionales) {
        this.adicionales = adicionales;
    } 


    
}
