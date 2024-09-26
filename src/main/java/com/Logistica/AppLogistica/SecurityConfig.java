package com.Logistica.AppLogistica;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/crearUsuario").permitAll() // Permitir acceso a la raíz y crear usuario
                        .anyRequest().permitAll() // Permitir acceso a todas las demás rutas
                )
                .csrf(csrf -> csrf.disable()) // Desactivar protección CSRF
                .formLogin(form -> form.disable()); // Desactivar formulario de login
        return http.build();
    }
}
