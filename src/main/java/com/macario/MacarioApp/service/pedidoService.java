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

    public BigDecimal calcularTotal(List<PedidoModel> pedidos) {
        BigDecimal total = BigDecimal.ZERO;
        for (PedidoModel pedido : pedidos) {
            total = total.add(pedido.getTotal());
        }
        return total;
    }


    
    

  
}
