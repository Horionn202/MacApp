package com.macario.MacarioApp.service;


import com.macario.MacarioApp.models.CarneModel;
import com.macario.MacarioApp.repositories.carneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class carneService {
    @Autowired

    private carneRepository carneRepo;


    public List<CarneModel> listarCarne() {
        return carneRepo.findAll();
    }

    public CarneModel guardarCarne(CarneModel carne) {
        return carneRepo.save(carne);
    }

    public void eliminar(Integer id_carne){
        carneRepo.deleteById(id_carne);
    }

    public CarneModel buscarPorId(Integer id_carne) {
        return carneRepo.findById(id_carne).orElse(null);
    }

}
