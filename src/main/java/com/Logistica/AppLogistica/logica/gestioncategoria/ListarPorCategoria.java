package com.Logistica.AppLogistica.logica.gestioncategoria;

import com.Logistica.AppLogistica.logica.gestionproducto.ProductoORM;
import com.Logistica.AppLogistica.logica.gestionproducto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ListarPorCategoria {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/categoria/{idCategoria}")
    public List<ProductoORM> listarPorCategoria(@PathVariable String idCategoria) {
        return productoService.listarProductosPorCategoria(idCategoria);
    }
}