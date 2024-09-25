package com.Logistica.AppLogistica.logica.GestionCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente añadirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(String id) {
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(String id) {
        clienteRepository.deleteById(id);
    }

    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}