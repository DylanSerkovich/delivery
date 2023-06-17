package com.business.delivery.controller;

import com.business.delivery.repository.CategoriaRepository;
import com.business.delivery.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @Autowired private ProductoRepository productRepo;

    @Autowired private CategoriaRepository categoryRepo;

    @GetMapping("/carta")
    public String Carta(Model model){
        model.addAttribute("productos",productRepo.findAll());
        model.addAttribute("categorias", categoryRepo.findAll());
        return "Carta";
    }

}
