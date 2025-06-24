package com.macario.MacarioApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


import com.macario.MacarioApp.service.adicionalService;
import com.macario.MacarioApp.service.carneService;
import com.macario.MacarioApp.service.frutaService;

import com.macario.MacarioApp.models.PedidoModel;
import com.macario.MacarioApp.service.pedidoService;

@Controller
public class PedidoController {

    @Autowired
    private pedidoService pedservice;
    private carneService carneService;
    private frutaService frutaService;
    private adicionalService adicionalService;


    @GetMapping("/vista/listarPedido")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedservice.listarPedidos());
        return "listar-pedidos"; 
    }
    
    @GetMapping("/vista/pedido")
    public String mostrarFormulario(Model model) {
    model.addAttribute("pedido", new PedidoModel());
    model.addAttribute("listaCarnes", carneService.listarCarne());
    model.addAttribute("listaFrutas", frutaService.listarFrutas());
    model.addAttribute("listaAdicionales", adicionalService.listarAdicional());
    return "formulario-pedido"; 
    }

    


}
