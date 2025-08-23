package com.example.demo.servicios.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.Categoria;
import com.example.demo.modelos.Platillo;

public interface IPlatilloService {

    List<Platillo> obtenerTodos();

    Page<Platillo> findByNombreContainingAndPrecioAndCategoria(String nombre, BigDecimal precio, Categoria categoria, Pageable pageable);

    Optional<Platillo> obtenerPorId(Integer id);

    Platillo crearOEditar(Platillo platillo);

    void eliminarPorId(Integer id);

}
