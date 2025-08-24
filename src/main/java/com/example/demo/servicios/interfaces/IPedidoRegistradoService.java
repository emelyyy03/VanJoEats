package com.example.demo.servicios.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.modelos.Usuario;

public interface IPedidoRegistradoService {

    List<PedidoRegistrado> obtenerTodos();       

    Page<PedidoRegistrado> findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndCliente(int numPedido, LocalDate fechaPedido, String detallePedido, Usuario cliente, Pageable pageable);

    Optional<PedidoRegistrado> obtenerPorId(Integer id);

    PedidoRegistrado crearOEditar(PedidoRegistrado pedidoRegistrado);

    void eliminarPorId(Integer id);

}
