package com.macario.MacarioApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macario.MacarioApp.models.ProductoModel;
import com.macario.MacarioApp.repositories.productoRepository;

@Service
public class productoService {

    @Autowired
    private productoRepository productoRepo;

    public List<ProductoModel> listarProductos() {
        return productoRepo.findAll();
    }

    public ProductoModel guardarProducto (ProductoModel producto){
        return productoRepo.save(producto);
    }



    public ProductoModel buscarporId (Integer id_Producto){
        return productoRepo.findById(id_Producto).orElse(null);
    }


    public void eliminar(Integer id_producto) {
        productoRepo.deleteById(id_producto);
    }



}
