package com.Logistica.AppLogistica.logica.gestioncategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria agregarCategoria(Categoria categoria) {
        Categoria categoriaExistente = categoriaRepository.findByNombreCategoria(categoria.getNombreCategoria());
        if (categoriaExistente != null) {
            throw new IllegalArgumentException("La categoría ya existe.");
        }
        return categoriaRepository.save(categoria);
    }

    public Categoria editarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean eliminarCategoria(String id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}