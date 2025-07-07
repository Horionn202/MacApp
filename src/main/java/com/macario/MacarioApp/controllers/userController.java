package com.macario.MacarioApp.controllers;


import com.macario.MacarioApp.models.userModel;
import com.macario.MacarioApp.service.userService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {
    @Autowired
    userService service;

    @GetMapping("/vista/login")
    public String login(Model model) {
        model.addAttribute("userModel", new userModel());
        return "login";
    }

 


    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(required = false) String error, Model model){
        if (error!=null){
            model.addAttribute("error","Correo o contraseña Incorrecta");
        }
        return "index";
    }

    @PostMapping("/login")
    public String proceserLogin (@RequestParam String email,
                                 @RequestParam String password,
                                 HttpSession session
    ){
        userModel user = service.autenticarUsuario(email,password);

        if (user!=null){
            System.out.println("Login correcto: " + user.getEmail());
            System.out.println("Rol en BD: '" + user.getRol() + "'");
            session.setAttribute("UsuarioLogueado", user);
            if ("admin".equalsIgnoreCase(user.getRol())) {
                return "redirect:/vista/admin";
            } else {
                return "redirect:/vista/interfaz";
            }

        } else {

            return "/vista/login";
        }

    }



}
