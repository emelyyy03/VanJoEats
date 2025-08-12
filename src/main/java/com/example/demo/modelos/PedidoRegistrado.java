package com.example.demo.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class PedidoRegistrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @NotNull(message = "Debe generar un número de pedido")
    private Integer numPedido;

    @NotNull(message = "Debe ingresar la fecha del pedido")
    private LocalDate fechaPedido;

    @NotBlank(message = "El detalle del pedido es obligatorio")
    private String detallePedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", nullable = false)
    private Usuario cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlatillo", nullable = false)
    private Platillo platillos_pedidos;

}
