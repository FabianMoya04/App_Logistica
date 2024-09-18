package com.Logistica.AppLogistica.logica;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Logistica.AppLogistica.bd.jpa.UsuariosJPA;
import com.Logistica.AppLogistica.bd.orm.UsuariosORM;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosJPA usuariosJPA;

    public List<UsuariosORM> allUsuarios() {
        return usuariosJPA.findAll();
    }
    
    public Optional<UsuariosORM> singleUsuario(ObjectId _id){
        return usuariosJPA.findById(_id);
    }

}
