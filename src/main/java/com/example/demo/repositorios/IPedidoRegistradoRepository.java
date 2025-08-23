package com.example.demo.repositorios;

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.modelos.Platillo;
import com.example.demo.modelos.Usuario;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRegistradoRepository extends JpaRepository<PedidoRegistrado, Integer> {
    Page<PedidoRegistrado> findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndClienteAndPlatillo(
             int numPedido, Date fechaPedido, String detallePedido, Usuario cliente, Platillo platillo, Pageable pageable);
}
