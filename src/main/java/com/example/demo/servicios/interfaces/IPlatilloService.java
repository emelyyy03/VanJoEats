package com.example.demo.servicios.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.Platillo;

public interface IPlatilloService {

    List<Platillo> obtenerTodos();

    Page<Platillo> findByNombreContainingAndPrecioContainingAndCategoriaContaining(String nombre, BigDecimal precio, String categoria, Pageable pageable);

    Platillo obtenerPorId(Integer id);

    Platillo crearOEditar(Platillo platillo);

    void eliminarPorId(Integer id);

}
