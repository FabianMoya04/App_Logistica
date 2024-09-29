package com.Logistica.AppLogistica.logica.gestionorden;

import lombok.Data;
import com.Logistica.AppLogistica.logica.gestioncliente.Cliente;
import com.Logistica.AppLogistica.logica.gestionproducto.ProductoORM;
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

    private List<ProductoORM> productos;

    private LocalDateTime fechaOrden;

    private BigDecimal total;
}