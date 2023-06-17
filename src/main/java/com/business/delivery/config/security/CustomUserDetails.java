package com.business.delivery.config.security;

import com.business.delivery.model.Rol;
import com.business.delivery.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails implements UserDetails {

    private Usuario usuario;

    public CustomUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Rol rol: roles){
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.getPasswordUsuario();
    }

    @Override
    public String getUsername() {
        return usuario.getEmailUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.isEnabled();
    }

    public String getNameSesion() {
        return usuario.getNomUsuario();
        //FormatNameUtil.capitalize(persona.getNom_persona());
    }
}
