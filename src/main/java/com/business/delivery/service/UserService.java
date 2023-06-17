package com.business.delivery.service;

import com.business.delivery.dto.ResponseUserDTO;
import com.business.delivery.exceptions.CustomerNotFoundException;
import com.business.delivery.model.Persona;
import com.business.delivery.model.Rol;
import com.business.delivery.model.Usuario;
import com.business.delivery.repository.PersonaRepository;
import com.business.delivery.repository.RolRepository;
import com.business.delivery.repository.UsuarioRepository;
import com.business.delivery.util.CodeRandomProvide;
import com.business.delivery.util.URL;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserService {

    @Autowired private PersonaRepository personRepo;
    @Autowired private UsuarioRepository userRepo;

    @Autowired private RolRepository rolRepo;

    @Autowired private MailService mailService;

    public ResponseUserDTO registrarCliente(Persona persona, String urlSite, BindingResult result) throws MessagingException, UnsupportedEncodingException {

        ResponseUserDTO responseUser = new ResponseUserDTO();

        boolean hasErrors = result.hasErrors();

        responseUser.setValidated(!hasErrors);

        if(hasErrors){
            responseUser.setErrors(result);
            return responseUser;
        }

        responseUser.setExists(isUserExits(persona.getUsuario().getEmailUsuario()));

        if(responseUser.isExists()){
            return responseUser;
        }else{
            persona.getUsuario().addRole(rolRepo.findRolByName("CLIENTE"));
            persona.getUsuario().setPasswordUsuario(PasswordEncode(persona.getUsuario().getPasswordUsuario()));
            persona.getUsuario().setVerificationCode(CodeRandomProvide.get(60));
            ExecutorService executor = Executors.newSingleThreadExecutor();
            CompletableFuture.runAsync(() -> personRepo.save(persona), executor);
            mailService.sendVerificationEmail(persona,urlSite);
            return responseUser;
        }
    }

    public boolean isUserExits(String email){
        Usuario userAux = userRepo.findByEmailEnable(email, 1);
        return userAux!= null;
    }

    private String PasswordEncode(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public boolean verify(String verificationCode) {
        Usuario usuario = userRepo.findByVerificationCode(verificationCode);
        if (usuario == null || usuario.isEnabled()) {
            return false;
        } else {
            usuario.setVerificationCode(null);
            usuario.setEnabled(true);
            userRepo.save(usuario);
            return true;
        }
    }

    public void sendPasswordResetToken(String email, HttpServletRequest request) throws CustomerNotFoundException, MessagingException, UnsupportedEncodingException {
        Usuario usuario = userRepo.findByEmailEnableRole(email,true,"CLIENTE");
        String token = CodeRandomProvide.get(30);
        if (usuario!= null){
            String LinkResetPass = URL.getSiteURL(request)+ "/new_password?token="+token;
            usuario.setResetPasswordToken(token);
            userRepo.save(usuario);
            mailService.SenResetPassEmail(email,LinkResetPass);
        }else{
            throw new CustomerNotFoundException("No se pudo encontrar ningún cliente con el correo electrónico. " + email);
        }
    }


    public void setResetPasswordToken(String token) throws CustomerNotFoundException {
        Usuario usuario = userRepo.finByResetPasswordToken(token);
        if (usuario == null){
            throw new CustomerNotFoundException("Token Invalido");
        }
    }

    public void updatePassword(String token, String newPassword) throws CustomerNotFoundException {
        Usuario usuario = userRepo.finByResetPasswordToken(token);
        if (usuario == null){
            throw new CustomerNotFoundException("Token Invalido");
        }else{
            usuario.setPasswordUsuario(PasswordEncode(newPassword));
            usuario.setResetPasswordToken(null);
            userRepo.save(usuario);
        }
    }

}
