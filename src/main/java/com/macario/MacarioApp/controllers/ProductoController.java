package com.macario.MacarioApp.controllers;


import com.macario.MacarioApp.models.CarneModel;
import com.macario.MacarioApp.models.FrutaModel;
import com.macario.MacarioApp.models.AdicionalModel;

import com.macario.MacarioApp.service.adicionalService;
import com.macario.MacarioApp.service.carneService;
import com.macario.MacarioApp.service.frutaService;

import java.math.BigDecimal;

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
    private adicionalService adiservice;




    //todas las vistas
    @GetMapping("vista/Carne")
    public String mostrarCarneForm(Model model) {
        model.addAttribute("carne", new CarneModel());
        return "carneForm";
    }
    @GetMapping("vista/Fruta")
    public String mostrarFrutaForm(Model model) {
        model.addAttribute("fruta", new FrutaModel());
        return "frutaForm";
    }
    @GetMapping("vista/Adicional")
    public String mostrarAdicionalForm(Model model) {   
        model.addAttribute("adicional", new AdicionalModel());
        return "adicionalForm";
    }
  

    // Todos los Listar 
    @GetMapping("/vista/ListarCarne")
    public String mostrarCarne(Model model) {
        model.addAttribute("carne",carservice.listarCarne());
        return "carne";
    }

    @GetMapping("/vista/ListarFruta")
    public String mostrarFruta(Model model){
        model.addAttribute("fruta",fruservice.listarFrutas());
        return "fruta";
    }

    @GetMapping("/vista/ListarAdicional")
    public String mostrarAdicional(Model model){
        model.addAttribute("adicional",adiservice.listarAdicional());
        return "adicional";
    }

    //todos los Eliminar

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

    @GetMapping("/eliminar/{id_adicional}")
    public String eliminarAdicional(@PathVariable Integer id_adicional){
        adiservice.eliminar(id_adicional);
        return "redirect:/vista/ListarAdicional";
    }


    //todos los guardar

    @PostMapping("/carne/guardar")
    public String guardarCarne (@RequestParam("nombre") String nombre,
                                @RequestParam("descripcion") String descripcion,
                                @RequestParam("cantidad") String cantidad){
        CarneModel carne = new CarneModel();
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
        FrutaModel fruta = new FrutaModel();
        fruta.setNombre(nombre);
        fruta.setDescripcion(descripcion);
        fruta.setCantidad(Integer.parseInt(cantidad));

        fruservice.guardarFruta(fruta);
        return "redirect:/vista/ListarFruta";
    }

    @PostMapping("/adicional/guardar")
    public String guardarAdicional (@RequestParam("nombre") String nombre,
                                    @RequestParam("precio") BigDecimal precio,
                                    @RequestParam("cantidad") String cantidad){
        AdicionalModel adicional = new AdicionalModel();
        adicional.setNombre(nombre);
        adicional.setPrecio(precio);
        adicional.setCantidad(cantidad);

        adiservice.guardarAdicional(adicional);
        return "redirect:/vista/ListarAdicional";
    }



    

}
