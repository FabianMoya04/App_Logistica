package com.Logistica.AppLogistica.logica.autenticacionusuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/crearUsuario")
    UsuariosORM newUsuariosORM(@RequestBody UsuariosORM newUsuariosORM) {
        return usuarioRepository.save(newUsuariosORM);
    }


}
