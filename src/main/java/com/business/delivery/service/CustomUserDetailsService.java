package com.business.delivery.service;

import com.business.delivery.config.security.CustomUserDetails;
import com.business.delivery.model.Usuario;
import com.business.delivery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepo.verifyUserLogin(username);
        if(usuario == null){
            throw new UsernameNotFoundException("El usuario no se encontro");
        }
        return new CustomUserDetails(usuario);
    }
}
