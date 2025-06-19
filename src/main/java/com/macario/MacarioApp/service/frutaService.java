package com.macario.MacarioApp.service;

import com.macario.MacarioApp.models.FrutaModel;
import com.macario.MacarioApp.repositories.frutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class frutaService {
    @Autowired
    private frutaRepository frutarepo;

    public List<FrutaModel> listarFrutas() {
        return frutarepo.findAll();
    }

    public FrutaModel guardarFruta(FrutaModel fruta){
        return frutarepo.save(fruta);
    }

    public void eliminar(Integer id_fruta){
        frutarepo.deleteById(id_fruta);
    }

}
