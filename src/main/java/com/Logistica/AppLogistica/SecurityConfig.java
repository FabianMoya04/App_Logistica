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
                        .requestMatchers("/", "/crearUsuario").permitAll() // Permite acceso público
                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF
                .formLogin(form -> form.disable()); // Desactiva el formulario de login
        return http.build();
    }
}
