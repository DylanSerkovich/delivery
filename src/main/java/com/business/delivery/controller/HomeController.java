package com.business.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping("/")
    public String inicio(Model model){
        return "MenuPrincipal";
    }

    @GetMapping("/ubicacion")
    public String ubicacion(Model model) {
        return "Ubicanos";
    }

}
