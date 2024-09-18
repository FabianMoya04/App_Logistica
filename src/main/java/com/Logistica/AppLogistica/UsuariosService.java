package com.Logistica.AppLogistica;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosJPA usuariosJPA;

    public List<Usuarios> allUsuarios() {
        return usuariosJPA.findAll();
    }
    
    public Optional<Usuarios> singleUsuario(ObjectId _id){
        return usuariosJPA.findById(_id);
    }

}
