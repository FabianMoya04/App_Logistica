package com.Logistica.AppLogistica.logica.GestionCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public ResponseEntity<Categoria> agregar(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable String id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        Categoria categoriaEditada = categoriaService.editarCategoria(categoria);
        if (categoriaEditada != null) {
            return ResponseEntity.ok(categoriaEditada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (categoriaService.eliminarCategoria(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}