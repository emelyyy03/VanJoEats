package com.example.demo.repositorios;

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.modelos.Usuario;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRegistradoRepository extends JpaRepository<PedidoRegistrado, Integer> {
    Page<PedidoRegistrado> findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndCliente(
             int numPedido, LocalDate fechaPedido, String detallePedido, Usuario cliente, Pageable pageable);
}
