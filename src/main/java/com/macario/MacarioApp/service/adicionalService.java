package com.macario.MacarioApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.macario.MacarioApp.repositories.adicionalRepository;
import com.macario.MacarioApp.models.AdicionalModel;
import org.springframework.stereotype.Service;

@Service
public class adicionalService {

    @Autowired
    private adicionalRepository adicionalRepo;

    public List<AdicionalModel> listarAdicional() {
        return adicionalRepo.findAll();
    }

    public AdicionalModel guardarAdicional (AdicionalModel adicional){
        return adicionalRepo.save(adicional);
    }

    public AdicionalModel buscarporId (Integer id_adicional){
        return adicionalRepo.findById(id_adicional).orElse(null);
    }


    public void eliminar(Integer id_adicional) {
        adicionalRepo.deleteById(id_adicional);
    }





}
