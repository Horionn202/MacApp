package com.macario.MacarioApp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "Usuario")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String rol;

    //getters
    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getTelefono() {
        return telefono;
    }

    //setters
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
