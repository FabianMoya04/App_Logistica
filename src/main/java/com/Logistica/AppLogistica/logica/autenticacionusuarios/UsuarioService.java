package com.Logistica.AppLogistica.logica.autenticacionusuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return usuarioRepository.save(usuario);
    }

    public Usuario encontrarUsuarioPorEmail(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean eliminarUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario editarUsuario(Usuario usuario) {
        // Verificar que el usuario existe antes de actualizar
        if (!usuarioRepository.existsById(usuario.getId())) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public boolean validarContraseña(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}