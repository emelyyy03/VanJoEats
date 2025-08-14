package com.example.demo.servicios.implementaciones;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.repositorios.IPedidoRegistradoRepository;
import com.example.demo.servicios.interfaces.IPedidoRegistradoService;

public class PedidoRegistradoService implements IPedidoRegistradoService {

    @Autowired
    private IPedidoRegistradoRepository pedidoRegistradoRepository;

    @Override
    public List<PedidoRegistrado> obtenerTodos() {
        return pedidoRegistradoRepository.findAll();
    }

    @Override
    public Page<PedidoRegistrado> findByNombreContainingAndNumPedidoContainingAndFechaPedidoContainingAndDetallePedidoContainingAndClienteContaining(
            String nombre, int numPedido, Date fechaPedido, String detallePedido, String cliente, Pageable pageable) {
        return pedidoRegistradoRepository
                .findByNombreContainingAndNumPedidoContainingAndFechaPedidoContainingAndDetallePedidoContainingAndClienteContaining(
                        nombre, numPedido, fechaPedido, detallePedido, cliente, pageable);
    }

    @Override
    public PedidoRegistrado obtenerPorId(Integer id) {
        return pedidoRegistradoRepository.findById(id).get();
    }

    @Override
    public void eliminarPorId(Integer id) {
        pedidoRegistradoRepository.deleteById(id);
    }

}
