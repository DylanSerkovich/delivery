package com.business.delivery.config.security;

import com.business.delivery.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ClienteConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain filterChar2(HttpSecurity http) throws Exception{

        http.csrf().disable();

        http.requestCache().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/pagar","/miCuenta","/misPedidos").hasAuthority("CLIENTE");
                    auth.anyRequest().permitAll();
                })
                .formLogin()
                    .loginPage("/login_cliente")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login_cliente")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }

}
