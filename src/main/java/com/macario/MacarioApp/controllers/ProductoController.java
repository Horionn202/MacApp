package com.macario.MacarioApp.controllers;


import com.macario.MacarioApp.models.carneModel;
import com.macario.MacarioApp.models.frutaModel;
import com.macario.MacarioApp.models.AdicionalModel;
import com.macario.MacarioApp.models.ProductoModel;
import com.macario.MacarioApp.service.adicionalService;
import com.macario.MacarioApp.service.carneService;
import com.macario.MacarioApp.service.frutaService;
import com.macario.MacarioApp.service.productoService;

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
    private productoService prodservice;

    // Todos los Mostrar
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

    @GetMapping("/adicional")
    public String mostrarAdicional(Model model){
        model.addAttribute("adicional",adiservice.listarAdicional());
        return "adicional";
    }

    @GetMapping("/producto")
    public String mostrarProducto(Model model){
        model.addAttribute("producto",prodservice.listarProductos());
        return "producto";
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

    @GetMapping("/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable Integer id_producto){
        prodservice.eliminar(id_producto);
        return "redirect:/vista/ListarProducto";
    }

    //todos los guardar

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

    @PostMapping("/adicional/guardar")
    public String guardarAdicional (@RequestParam("nombre") String nombre,
                                    @RequestParam("precio") double precio,
                                    @RequestParam("cantidad") String cantidad){
        AdicionalModel adicional = new AdicionalModel();
        adicional.setNombre(nombre);
        adicional.setPrecio(precio);
        adicional.setCantidad(cantidad);

        adiservice.guardarAdicional(adicional);
        return "redirect:/vista/ListarAdicional";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto (@RequestParam("nombre") String nombre,
                                    @RequestParam("precio") double precio,
                                    @RequestParam("cantidad") String cantidad,
                                    @RequestParam("descripcion") String descripcion){
        ProductoModel producto = new ProductoModel();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setDescripcion(descripcion);

        prodservice.guardarProducto(producto);
        return "redirect:/vista/ListarProducto";
    }



}
