package com.business.delivery.controller;

import com.business.delivery.dto.ResponseUserDTO;
import com.business.delivery.model.Distrito;
import com.business.delivery.model.Persona;
import com.business.delivery.repository.DistritoRepository;
import com.business.delivery.service.UserService;
import com.business.delivery.util.URL;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class AuthController {

    @Autowired UserService userService;

    @Autowired DistritoRepository distritoRepo;

    @GetMapping("/login_cliente")
    public String LoginCliente(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
            return "Login";
        else
            return "/";
    }

    @GetMapping("/registrate")
    public String pgPrincipal(Model model) {
        model.addAttribute("distritos", distritoRepo.findAll());
        model.addAttribute("cliente", new Persona());
        return "RegistrarCliente";
    }

    @PostMapping(value = "/registrate" , produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseUserDTO registroClienteP(Model model,
                                            @Validated @ModelAttribute("persona") Persona cliente,
                                            BindingResult result,
                                            HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        System.out.println("Accion registrate");
        System.out.println(cliente.getApePersona());
        return userService.registrarCliente(cliente, URL.getSiteURL(request), result);
        //return new ResponseUserDTO();
    }



    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code, Model model, RedirectAttributes redirectAttributes) {
        if (userService.verify(code)) {
            redirectAttributes.addFlashAttribute("flag", "iniciarSesion");
            return "redirect:login_cliente";
        } else {
            model.addAttribute("title", "¡Error de Confirmacion!");
            model.addAttribute("mensaje", "Token Invalido, o el usuario ya esta verificado");
            return "mensaje";
        }
    }

}
