package com.macario.MacarioApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "boletas")
public class BoletaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_boleta;
    

}
