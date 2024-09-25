package com.Logistica.AppLogistica.logica.gestioncliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ResponseEntity<Cliente> añadirCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.añadirCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteService.obtenerClientePorId(id);
        if (clienteExistente.isPresent()) {
            cliente.setId_cliente(id);
            Cliente clienteEditado = clienteService.editarCliente(cliente);
            return ResponseEntity.ok(clienteEditado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String id) {
        if (clienteService.obtenerClientePorId(id).isPresent()) {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}