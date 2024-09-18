package com.Logistica.AppLogistica.logica.GestionCategoria;

import com.Logistica.AppLogistica.logica.GestionProducto.Producto;
import com.Logistica.AppLogistica.logica.GestionProducto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ListarPorCategoria {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/categoria/{idCategoria}")
    public List<Producto> listarPorCategoria(@PathVariable String idCategoria) {
        return productoService.listarProductosPorCategoria(idCategoria);
    }
}