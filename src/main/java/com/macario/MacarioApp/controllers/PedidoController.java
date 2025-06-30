package com.macario.MacarioApp.controllers;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import com.macario.MacarioApp.service.adicionalService;
import com.macario.MacarioApp.service.carneService;
import com.macario.MacarioApp.service.frutaService;
import com.macario.MacarioApp.models.AdicionalModel;
import com.macario.MacarioApp.models.CarneModel;
import com.macario.MacarioApp.models.FrutaModel;
import com.macario.MacarioApp.models.PedidoModel;
import com.macario.MacarioApp.service.pedidoService;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


@Controller
public class PedidoController {

    @Autowired
    private pedidoService pedservice;
     @Autowired
    private carneService carneService;
     @Autowired
    private frutaService frutaService;
     @Autowired
    private adicionalService adicionalService;


   @GetMapping("/pedidos")
    public String mostrarPedidos(Model model) {
    List<PedidoModel> pedidos = pedservice.listarTodos(); // debe incluir los pedidos guardados
    model.addAttribute("pedidos", pedidos);
    return "ListarPedido"; // archivo HTML que mostrarás
}
    
    @GetMapping("/vista/interfaz")
    public String mostrarInterfaz(Model model) {
        List<PedidoModel> pedidos = pedservice.listarTodos();
        model.addAttribute("pedidos", pedidos);
        return "interfaz";
    }


    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        List<CarneModel> carnes = carneService.listarCarne();
        List<FrutaModel> frutas = frutaService.listarFrutas();
        List<AdicionalModel> adicionales = adicionalService.listarAdicional();

        System.out.println("CARNES CARGADAS: " + carnes.size()); // <== esto es clave

        model.addAttribute("carnes", carnes);
        model.addAttribute("frutas", frutas);
        model.addAttribute("adicionales", adicionales);

        return "productoFrom"; // Este nombre debe coincidir con tu archivo .html
    }

  
    //guardar pedido
                @PostMapping("/crear")
                public String guardarPedido(@RequestParam Map<String, String> params) {
                    PedidoModel pedido = new PedidoModel();
                    pedido.setFecha(LocalDate.parse(params.get("fecha")));
                    pedido.setHora(LocalTime.parse(params.get("hora")));

                    // Cargar carnes
                    List<CarneModel> carnes = new ArrayList<>();
                    Map<Integer, Integer> cantidadCarnes = new HashMap<>();
                    for (String key : params.keySet()) {
                        if (key.startsWith("cantidad_carne_")) {
                            Integer id = Integer.parseInt(key.replace("cantidad_carne_", ""));
                            Integer cantidad = Integer.parseInt(params.get(key));
                            CarneModel carne = carneService.buscarPorId(id);
                            carnes.add(carne);
                            cantidadCarnes.put(id, cantidad);
                        }
                    }
                    pedido.setCarnes(carnes);
                    pedido.setCantidadCarnes(cantidadCarnes);

                    // Repetir lo mismo para frutas
                    List<FrutaModel> frutas = new ArrayList<>();
                    Map<Integer, Integer> cantidadFrutas = new HashMap<>();
                    for (String key : params.keySet()) {
                        if (key.startsWith("cantidad_fruta_")) {
                            Integer id = Integer.parseInt(key.replace("cantidad_fruta_", ""));
                            Integer cantidad = Integer.parseInt(params.get(key));
                            FrutaModel fruta = frutaService.buscarPorId(id);
                            frutas.add(fruta);
                            cantidadFrutas.put(id, cantidad);
                        }
                    }
                    pedido.setFrutas(frutas);
                    pedido.setCantidadFrutas(cantidadFrutas);

                    // Y para adicionales
                    List<AdicionalModel> adicionales = new ArrayList<>();
                    Map<Integer, Integer> cantidadAdicionales = new HashMap<>();
                    for (String key : params.keySet()) {
                        if (key.startsWith("cantidad_adicional_")) {
                            Integer id = Integer.parseInt(key.replace("cantidad_adicional_", ""));
                            Integer cantidad = Integer.parseInt(params.get(key));
                            AdicionalModel adicional = adicionalService.buscarporId(id);
                            adicionales.add(adicional);
                            cantidadAdicionales.put(id, cantidad);
                        }
                    }
                    pedido.setAdicionales(adicionales);
                    pedido.setCantidadAdicionales(cantidadAdicionales);

                    // Calcular total si tienes un método:
                    pedservice.calcularTotal(pedido);

                    pedservice.guardar(pedido);

                    return "redirect:/pedidos"; // Redirecciona a lista de pedidos
                }




    


}
