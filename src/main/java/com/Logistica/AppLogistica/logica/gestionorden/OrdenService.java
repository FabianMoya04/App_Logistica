package com.Logistica.AppLogistica.logica.gestionorden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> obtenerOrdenPorId(String id) {
        return ordenRepository.findById(id);
    }

    public Orden crearOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void eliminarOrden(String id) {
        ordenRepository.deleteById(id);
    }
}