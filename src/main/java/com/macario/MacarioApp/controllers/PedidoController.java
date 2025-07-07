package com.macario.MacarioApp.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.macario.MacarioApp.models.*;
import com.macario.MacarioApp.service.*;
import java.util.Map;

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

    @Autowired
    private boletaService boletaService;

    @GetMapping("/pedidos")
    public String mostrarPedidos(Model model) {
        List<PedidoModel> pedidos = pedservice.listarTodos();
        model.addAttribute("pedidos", pedidos);
        return "ListarPedido";
    }
@GetMapping("/vista/admin")
public String mostrarAdmin(Model model) {
    List<PedidoModel> pedidos = pedservice.listarTodos();
    model.addAttribute("pedidos", pedidos);

    model.addAttribute("carne", new CarneModel());
    model.addAttribute("fruta", new FrutaModel());
    model.addAttribute("adicional", new AdicionalModel());

    // Listas vacías para que Thymeleaf no falle
    model.addAttribute("carnes", carneService.listarCarne());
    model.addAttribute("frutas",  frutaService.listarFrutas());
    model.addAttribute("adicionales",   adicionalService.listarAdicional());

    
    model.addAttribute("pedidos", pedservice.listarTodos());

    return "admin";
}

    @GetMapping("/vista/interfaz")
    public String mostrarInterfaz(Model model) {
        List<PedidoModel> pedidos = pedservice.listarTodos();
        model.addAttribute("pedidos", pedidos);
        return "interfaz";
    }

    @GetMapping("/editarPedido")
    public String editarPedido(@RequestParam Integer id_pedido, Model model) {
        PedidoModel pedido = pedservice.buscarPorId(id_pedido);
        model.addAttribute("pedido", pedido);
        model.addAttribute("carnes", carneService.listarCarne());
        model.addAttribute("adicionales", adicionalService.listarAdicional());
        model.addAttribute("frutas", frutaService.listarFrutas());
        return "editarPedidoForm";
    }

    @PostMapping("/editarPedido")
    public String guardarEdicion(
        @RequestParam Integer id_pedido,
        @RequestParam("fecha") String fecha,
        @RequestParam("hora") String hora,
        @RequestParam(value = "carne_id", required = false) Integer carneId,
        @RequestParam(value = "cantidadCarne", required = false, defaultValue = "0") Integer cantidadCarne,
        @RequestParam(value = "adicional_id", required = false) Integer adicionalId,
        @RequestParam(value = "cantidadAdicional", required = false, defaultValue = "0") Integer cantidadAdicional,
        @RequestParam(value = "frutas_id", required = false) Integer frutasId,
        @RequestParam(value = "cantidadFruta", required = false, defaultValue = "0") Integer cantidadFruta
    ) {
        PedidoModel pedido = pedservice.buscarPorId(id_pedido);
        pedido.setFecha(LocalDate.parse(fecha));
        pedido.setHora(LocalTime.parse(hora));

        CarneModel carne = (carneId != null) ? carneService.obtenerPorId(carneId) : null;
        AdicionalModel adicional = (adicionalId != null) ? adicionalService.obtenerPorId(adicionalId) : null;
        FrutaModel fruta = (frutasId != null) ? frutaService.obtenerPorId(frutasId) : null;

        pedido.setCantidadCarne(cantidadCarne);
        pedido.setCantidadAdicional(cantidadAdicional);
        pedido.setCantidadFruta(cantidadFruta);

        // Nuevas listas
        pedido.setCarnes((carne != null) ? Arrays.asList(carne) : null);
        pedido.setAdicionales((adicional != null) ? Arrays.asList(adicional) : null);
        pedido.setFrutas((fruta != null) ? Arrays.asList(fruta) : null);

        // Recalcular total
        BigDecimal total = BigDecimal.ZERO;
        if (carne != null && cantidadCarne > 0) {
            total = total.add(carne.getPrecio().multiply(BigDecimal.valueOf(cantidadCarne)));
        }
        if (adicional != null && cantidadAdicional > 0) {
            total = total.add(adicional.getPrecio().multiply(BigDecimal.valueOf(cantidadAdicional)));
        }
        if (fruta != null && cantidadFruta > 0) {
            total = total.add(fruta.getPrecio().multiply(BigDecimal.valueOf(cantidadFruta)));
        }
        pedido.setTotal(total);

        pedservice.guardar(pedido);
        return "redirect:/vista/interfaz";
    }

    @GetMapping("/eliminarPedido")
    public String eliminarPedido(@RequestParam Integer id_pedido) {
        pedservice.eliminar(id_pedido);
        return "redirect:/vista/interfaz";
    }

    @GetMapping("/vista/crearPedido")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("carnes", carneService.listarCarne());
        model.addAttribute("adicionales", adicionalService.listarAdicional());
        model.addAttribute("frutas", frutaService.listarFrutas());
        return "productoFrom";
    }

@PostMapping("/guardarPedido")
public String guardarPedido(
    @RequestParam("fecha") String fecha,
    @RequestParam("hora") String hora,
    @RequestParam(value = "carne_id", required = false) List<Integer> carnesIds,
    @RequestParam(value = "cantidadCarne", required = false) List<Integer> cantidadesCarnes,
    @RequestParam(value = "adicional_id", required = false) List<Integer> adicionalesIds,
    @RequestParam(value = "cantidadAdicional", required = false) List<Integer> cantidadesAdicionales,
    @RequestParam(value = "frutas_id", required = false) List<Integer> frutasIds,
    @RequestParam(value = "cantidadFruta", required = false) List<Integer> cantidadesFrutas
) {
    LocalDate fechaPedido = LocalDate.parse(fecha);
    LocalTime horaPedido = LocalTime.parse(hora);
    BigDecimal total = BigDecimal.ZERO;

    List<CarneModel> listaCarnes = new ArrayList<>();
    List<Integer> listaCantidadesCarnes = new ArrayList<>();

    if (carnesIds != null && cantidadesCarnes != null) {
        for (int i = 0; i < carnesIds.size(); i++) {
            Integer id = carnesIds.get(i);
            Integer cantidad = cantidadesCarnes.get(i);
            if (id != null && cantidad != null && cantidad > 0) {
                CarneModel carne = carneService.obtenerPorId(id);
                if (carne != null) {
                    total = total.add(carne.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
                    carne.setCantidad(carne.getCantidad() - cantidad);
                    carneService.guardarCarne(carne);
                    listaCarnes.add(carne);
                    listaCantidadesCarnes.add(cantidad);
                }
            }
        }
    }

    List<AdicionalModel> listaAdicionales = new ArrayList<>();
    List<Integer> listaCantidadesAdicionales = new ArrayList<>();
    if (adicionalesIds != null && cantidadesAdicionales != null) {
        for (int i = 0; i < adicionalesIds.size(); i++) {
            Integer id = adicionalesIds.get(i);
            Integer cantidad = cantidadesAdicionales.get(i);
            if (id != null && cantidad != null && cantidad > 0) {
                AdicionalModel adicional = adicionalService.obtenerPorId(id);
                if (adicional != null) {
                    total = total.add(adicional.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
                    adicional.setCantidad(adicional.getCantidad() - cantidad);
                    adicionalService.guardarAdicional(adicional);
                    listaAdicionales.add(adicional);
                    listaCantidadesAdicionales.add(cantidad);
                }
            }
        }
    }

    List<FrutaModel> listaFrutas = new ArrayList<>();
    List<Integer> listaCantidadesFrutas = new ArrayList<>();
    if (frutasIds != null && cantidadesFrutas != null) {
        for (int i = 0; i < frutasIds.size(); i++) {
            Integer id = frutasIds.get(i);
            Integer cantidad = cantidadesFrutas.get(i);
            if (id != null && cantidad != null && cantidad > 0) {
                FrutaModel fruta = frutaService.obtenerPorId(id);
                if (fruta != null) {
                    total = total.add(fruta.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
                    fruta.setCantidad(fruta.getCantidad() - cantidad);
                    frutaService.guardarFruta(fruta);
                    listaFrutas.add(fruta);
                    listaCantidadesFrutas.add(cantidad);
                }
            }
        }
    }

    PedidoModel pedido = new PedidoModel();
    pedido.setFecha(fechaPedido);
    pedido.setHora(horaPedido);
    pedido.setTotal(total);
    pedido.setCarnes(listaCarnes);
    pedido.setCantidadesCarnes(listaCantidadesCarnes);
    pedido.setAdicionales(listaAdicionales);
    pedido.setCantidadesAdicionales(listaCantidadesAdicionales);
    pedido.setFrutas(listaFrutas);
    pedido.setCantidadesFrutas(listaCantidadesFrutas);

    pedservice.guardar(pedido);

    return "redirect:/vista/interfaz";
}

@GetMapping("/generarBoleta/{id_pedido}")
public String generarBoleta(@PathVariable Integer id_pedido) {
    // Lógica para crear y guardar la boleta
    PedidoModel pedido = pedservice.buscarPorId(id_pedido);
    if (pedido != null) {
        BoletaModel boleta = new BoletaModel();
        boleta.setPedido(pedido);
        boleta.setFecha(LocalDate.now());
        boleta.setHora(LocalTime.now());
        boleta.setTotal(pedido.getTotal());
        boletaService.guardarBoleta(boleta);
    }

    return "redirect:/vista/interfaz"; // redirige a la página principal o donde quieras
}



}
