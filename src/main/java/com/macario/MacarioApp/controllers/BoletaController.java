package com.macario.MacarioApp.controllers;

import com.macario.MacarioApp.models.BoletaModel;
import com.macario.MacarioApp.models.PedidoModel;
import com.macario.MacarioApp.service.boletaService;
import com.macario.MacarioApp.service.pedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/boletas")
public class BoletaController {

    @Autowired
    private boletaService boletaService;
    @Autowired
    private pedidoService pedidoService;



@GetMapping("/vista/interfaz")
public String verInterfaz() {
    return "interfaz"; // nombre del archivo HTML sin extensión, por ejemplo interfaz.html
}

@GetMapping("/boleta/form")
public String mostrarFormularioBoleta(Model model) {
    model.addAttribute("boleta", new BoletaModel());
    return "boletaForm";
}

@PostMapping("/boleta/guardar")
public String guardarBoleta(@ModelAttribute BoletaModel boleta) {
    boletaService.guardarBoleta(boleta);
    return "redirect:/boleta/lista";
}

    @GetMapping("/eliminar/{id_boleta}")
    public String eliminarBoleta(@PathVariable Integer id_boleta) {
        boletaService.eliminarPorId(id_boleta);
        return "redirect:/boletas/lista";
    }


    @GetMapping("/lista")
    public String verBoletas(Model model) {
        List<BoletaModel> boletas = boletaService.obtenerTodas();
        model.addAttribute("boletas", boletas);
        return "listarBoleta";
    }

@GetMapping("/generarBoleta/{id_pedido}")
public String generarBoleta(@PathVariable Integer id_pedido, Model model) {
    PedidoModel pedido = pedidoService.buscarPorId(id_pedido);
    if (pedido != null) {
        BoletaModel boleta = new BoletaModel();
        boleta.setPedido(pedido);
        boleta.setFecha(LocalDate.now());
        boleta.setHora(LocalTime.now());
        boleta.setTotal(pedido.getTotal());
        boletaService.guardarBoleta(boleta);

        model.addAttribute("boleta", boleta);
        return "boletaDetalle";
    }
    return "redirect:/vista/interfaz";
}
}

