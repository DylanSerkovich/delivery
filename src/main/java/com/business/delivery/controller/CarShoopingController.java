package com.business.delivery.controller;

import com.business.delivery.config.security.CustomUserDetails;
import com.business.delivery.model.Persona;
import com.business.delivery.repository.PedidoRepository;
import com.business.delivery.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarShoopingController {

    @Autowired
    PersonaRepository personaRepo;

    @Autowired
    PedidoRepository pedidoRepo;

    @GetMapping("/misPedidos")
    public String historialPedidos(Model model,  @AuthenticationPrincipal CustomUserDetails userDetails) {

        if(userDetails != null){
            String emailUser = userDetails.getUsername();
            Persona persona = personaRepo.findByEmailEnable(emailUser, 1);
            model.addAttribute("pedidos", pedidoRepo.findAllbyClient(persona.getIdPersona()));

        }
        return "MisPedidos";
    }

    //@PreAuthorize("hasRole('CLIENTE')")
    @GetMapping(value="/ProductosPedidos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Object[]> listarProfesoresCurso(@PathVariable(name = "id") int id, Model model){

        List<Object[]> productos = pedidoRepo.finByProductosByPedido(id);

        return productos;
    }

}
