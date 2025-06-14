package com.macario.MacarioApp.controllers;


import com.macario.MacarioApp.models.carneModel;
import com.macario.MacarioApp.models.frutaModel;
import com.macario.MacarioApp.repositories.carneRepository;
import com.macario.MacarioApp.repositories.frutaRepository;
import com.macario.MacarioApp.service.carneService;
import com.macario.MacarioApp.service.frutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {
    @Autowired
    private carneService carservice;
    private frutaService fruservice;

    @GetMapping("/carne")
    public String mostrarCarne(Model model) {
        model.addAttribute("carne",carservice.listarCarne());
        return "carne";
    }

    @GetMapping("/fruta")
    public String mostrarFruta(Model model){
        model.addAttribute("fruta",fruservice.listarFrutas());
        return "fruta";
    }

    @GetMapping("/elimar/{id_carne}")
    public String eliminarCarne(@PathVariable Integer id_carne){
        carservice.eliminar(id_carne);
        return "redirect:/vista/ListarCarne";
    }

    @GetMapping("/eliminar/{id_fruta}")
    public String eliminarFruta(@PathVariable Integer id_fruta){
        fruservice.eliminar(id_fruta);
        return "redirect:/vista/ListarFruta";
    }

    @PostMapping("/carne/guardar")
    public String guardarCarne (@RequestParam("nombre") String nombre,
                                @RequestParam("descripcion") String descripcion,
                                @RequestParam("cantidad") String cantidad){
        carneModel carne = new carneModel();
        carne.setNombre(nombre);
        carne.setDescripcion(descripcion);
        carne.setCantidad(Integer.parseInt(cantidad));

        carservice.guardarCarne(carne);
        return "redirect:/vista/ListarCarne";
    }


    @PostMapping("/fruta/guardar")
    public String guardarFruta (@RequestParam("nombre") String nombre,
                                @RequestParam("descripcion") String descripcion,
                                @RequestParam("cantidad") String cantidad){
        frutaModel fruta = new frutaModel();
        fruta.setNombre(nombre);
        fruta.setDescripcion(descripcion);
        fruta.setCantidad(Integer.parseInt(cantidad));

        fruservice.guardarFruta(fruta);
        return "redirect:/vista/ListarFruta";
    }





}
