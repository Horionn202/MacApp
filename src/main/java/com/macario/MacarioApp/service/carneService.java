package com.macario.MacarioApp.service;


import com.macario.MacarioApp.models.carneModel;
import com.macario.MacarioApp.repositories.carneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class carneService {
    @Autowired

    private carneRepository carneRepo;


    public List<carneModel> listarCarne(carneModel carne) {
        return carneRepo.findAll();
    }

    public carneModel guardarCarne(carneModel carne) {
        return carneRepo.save(carne);
    }

    public void eliminarCarne(carneModel carne){
        carneRepo.delete(carne);
    }



}
