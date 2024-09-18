package com.Logistica.AppLogistica;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    
    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerUsuarios() {
        return new ResponseEntity<List<Usuarios>>(usuariosService.allUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{_id}")
    public ResponseEntity<Optional<Usuarios> > getItemById(@PathVariable("_id") ObjectId _id) {
        return new ResponseEntity<Optional<Usuarios>>(usuariosService.singleUsuario(_id), HttpStatus.OK);
    }
}
