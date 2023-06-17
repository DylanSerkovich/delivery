package com.business.delivery.controller;

import com.business.delivery.exceptions.CustomerNotFoundException;
import com.business.delivery.model.Usuario;
import com.business.delivery.service.UserService;
import com.business.delivery.util.URL;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
public class PasswordResetController{

    @Autowired
    UserService userService;

    @GetMapping("/reset-password")
    public String MostrarOlvidarPass(Model model) {
        return "RecuperarCuenta";
    }

    @PostMapping(value = "/reset-password")
    public String ProcesoOlvidarPass(@RequestParam("email") String email, Model model, HttpServletRequest request) {
        try{
            userService.sendPasswordResetToken(email,request);
        } catch (UnsupportedEncodingException  | MessagingException e) {
            model.addAttribute("error", "Error durante el envio de email");
        } catch (CustomerNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "RecuperarCuenta";
    }

    @GetMapping("/new_password")
    public String NewPassword(@Param(value = "token")String token, Model model ){
        try{
            userService.setResetPasswordToken(token);
            model.addAttribute("token", token);
        }catch (CustomerNotFoundException e){
            model.addAttribute("title", "Error en Restablecer Contraseña");
            model.addAttribute("mensaje",  e.getMessage());
            return "mensaje";
        }
        return "new-password-form";
    }


    @PostMapping("/new_password")
    public String ProcesoNewPassword(@RequestParam("password") String password,
                                     @RequestParam("token") String token, Model model){

        try{
            userService.updatePassword(token,password);
            model.addAttribute("mensaje", "Has cambiado satisfactoriamente tu contraseña");
        }catch (CustomerNotFoundException e){
            model.addAttribute("title", "Error en Restablecer Contraseña");
            model.addAttribute("mensaje",  e.getMessage());
            return "mensaje";
        }
        return "mensaje";
    }



}
