package com.example.demo.servicios.implementaciones;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.PedidoRegistrado;
import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.IPedidoRegistradoRepository;
import com.example.demo.servicios.interfaces.IPedidoRegistradoService;

@Service
public class PedidoRegistradoService implements IPedidoRegistradoService {

    @Autowired
    private IPedidoRegistradoRepository pedidoRegistradoRepository;

    @Override
    public List<PedidoRegistrado> obtenerTodos() {
        return pedidoRegistradoRepository.findAll();
    }

    @Override
    public Page<PedidoRegistrado> findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndCliente(
            int numPedido, LocalDate fechaPedido, String detallePedido, Usuario cliente,
            Pageable pageable) {
        return pedidoRegistradoRepository.findByNumPedidoAndFechaPedidoAndDetallePedidoContainingAndCliente(
                numPedido, fechaPedido, detallePedido, cliente, pageable);
    }

    @Override
    public Optional<PedidoRegistrado> obtenerPorId(Integer id) {
        return pedidoRegistradoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        pedidoRegistradoRepository.deleteById(id);
    }

    @Override
    public PedidoRegistrado crearOEditar(PedidoRegistrado pedidoRegistrado) {
        return pedidoRegistradoRepository.save(pedidoRegistrado);
    }

}
