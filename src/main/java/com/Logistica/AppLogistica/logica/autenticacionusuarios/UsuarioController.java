package com.Logistica.AppLogistica.logica.autenticacionusuarios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> newUsuariosORM(@RequestBody UsuariosORM newUsuariosORM) {
        List<UsuariosORM> existingUsers = usuarioRepository.findById(newUsuariosORM.getId());
        if (!existingUsers.isEmpty()) {
            return ResponseEntity.badRequest().body("Ya existe un usuario con el id: " + newUsuariosORM.getId());
        }
        UsuariosORM savedUser = usuarioRepository.save(newUsuariosORM);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/obtenerUsuarios")
    List<UsuariosORM> getAllUsuariosORMs() {
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int id) {
        List<UsuariosORM> usuarios = usuarioRepository.findById(id);
        if (usuarios.size() == 1) {
            usuarioRepository.delete(usuarios.get(0));
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } else if (usuarios.size() > 1) {
            return ResponseEntity.badRequest().body("Se encontraron múltiples usuarios con el mismo id");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
