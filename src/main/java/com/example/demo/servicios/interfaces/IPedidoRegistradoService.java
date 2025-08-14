package com.example.demo.servicios.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.PedidoRegistrado;

public interface IPedidoRegistradoService {

    List<PedidoRegistrado> obtenerTodos();

    Page<PedidoRegistrado> findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndClienteContaining(int numPedido, Date fechaPedido, String detallePedido, String cliente, Pageable pageable);

    PedidoRegistrado obtenerPorId(Integer id);

    void eliminarPorId(Integer id);

}
