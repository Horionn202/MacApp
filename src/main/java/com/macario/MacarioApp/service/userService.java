package com.macario.MacarioApp.service;

import com.macario.MacarioApp.models.userModel;
import com.macario.MacarioApp.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userService {
    @Autowired
    private userRepository userepo;

    public List<userModel> listar() {
        return userepo.findAll();
    }

    public userModel guardar(userModel user) {
        return userepo.save(user);
    }

    public void eliminar(userModel user) {
        userepo.delete(user);
    }
}
