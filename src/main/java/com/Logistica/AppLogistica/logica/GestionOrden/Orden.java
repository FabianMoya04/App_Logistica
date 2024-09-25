package com.Logistica.AppLogistica.logica.GestionOrden;

import lombok.Data;
import com.Logistica.AppLogistica.logica.GestionCliente.Cliente;
import com.Logistica.AppLogistica.logica.GestionProducto.Producto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "ordenes")
@Data
public class Orden {

    @Id
    private String idOrden;

    private Cliente cliente;

    private List<Producto> productos;

    private LocalDateTime fechaOrden;

    private BigDecimal total;
}