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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(String detallePedido) {
        this.detallePedido = detallePedido;
    }

    

}
