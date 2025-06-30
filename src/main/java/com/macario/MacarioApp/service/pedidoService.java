package com.macario.MacarioApp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macario.MacarioApp.repositories.pedidoRepository;
import com.macario.MacarioApp.models.PedidoModel;
import com.macario.MacarioApp.models.CarneModel;
import com.macario.MacarioApp.models.FrutaModel; 
import com.macario.MacarioApp.models.AdicionalModel;


@Service
public class pedidoService {
    @Autowired

    private pedidoRepository pedidorepo;

    public List<PedidoModel> listarTodos() {
    return pedidorepo.findAll(); // asegúrate que el repo está bien
}


    public PedidoModel guardar(PedidoModel pedido) {
        return pedidorepo.save(pedido);
    }

    public PedidoModel buscarPorId(Integer id_pedido) {
        return pedidorepo.findById(id_pedido).orElse(null);
    }
    
    public void eliminar(Integer id_pedido) {
        pedidorepo.deleteById(id_pedido);
    }


    public void calcularTotal(PedidoModel pedido){
        BigDecimal total = BigDecimal.ZERO;
        if(pedido.getCarnes() !=null && pedido.getCantidadCarnes() != null) {
           for (CarneModel carne : pedido.getCarnes()) {
            Integer cantidad = pedido.getCantidadCarnes().get(carne.getId_carne());
            if (cantidad != null) {
                total = total.add(carne.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
                 }
            }
        }

        if(pedido.getFrutas() !=null && pedido.getCantidadFrutas() != null) {
            for (FrutaModel fruta : pedido.getFrutas()) {
                Integer cantidad = pedido.getCantidadFrutas().get(fruta.getId_fruta());
                if (cantidad != null) {
                    total = total.add(fruta.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
                }
            }
        }

        if(pedido.getAdicionales() !=null) {
            for (AdicionalModel adicional : pedido.getAdicionales()) {
                total = total.add(adicional.getPrecio());
            }
        }

        pedido.setTotal(total);
    }
}
