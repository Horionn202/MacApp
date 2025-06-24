package com.macario.MacarioApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macario.MacarioApp.repositories.pedidoRepository;
import com.macario.MacarioApp.models.PedidoModel;

@Service
public class pedidoService {
    @Autowired

    private pedidoRepository pedidorepo;

    public List<PedidoModel> listarPedidos() {
        return pedidorepo.findAll();
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

}
