package com.Logistica.AppLogistica.logica.GestionOrden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> listarOrdenes() {
        return ordenService.listarOrdenes();
    }

    @PostMapping
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        Orden nuevaOrden = ordenService.crearOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> obtenerOrdenPorId(@PathVariable String id) {
        Optional<Orden> orden = ordenService.obtenerOrdenPorId(id);
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable String id) {
        if (ordenService.obtenerOrdenPorId(id).isPresent()) {
            ordenService.eliminarOrden(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}