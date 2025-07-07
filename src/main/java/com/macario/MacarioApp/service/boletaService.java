package com.macario.MacarioApp.service;

import com.macario.MacarioApp.models.BoletaModel;
import com.macario.MacarioApp.repositories.boletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class boletaService {

    @Autowired
    private boletaRepository boletaRepository;

    public List<BoletaModel> obtenerTodas() {
        return boletaRepository.findAll();
    }

    public BoletaModel obtenerPorId(Integer id_boleta) {
        return boletaRepository.findById(id_boleta).orElse(null);
    }

 public void guardarBoleta(BoletaModel boleta) {
        boletaRepository.save(boleta);
    }

    // Eliminar una boleta por ID
  public void eliminarPorId(Integer id) {
    boletaRepository.deleteById(id);
}

    

    
}
