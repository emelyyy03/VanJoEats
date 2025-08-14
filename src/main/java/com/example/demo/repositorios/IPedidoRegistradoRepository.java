package com.example.demo.repositorios;

import com.example.demo.modelos.PedidoRegistrado;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRegistradoRepository extends JpaRepository<PedidoRegistrado, Integer> {
    Page<PedidoRegistrado> findByNombreContainingAndNumPedidoContainingAndFechaPedidoContainingAndDetallePedidoContainingAndClienteContaining(
            String nombre, int numPedido, Date fechaPedido, String detallePedido, String cliente, Pageable pageable);
}
