package com.example.demo.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.Categoria;

public interface ICategoriaService {

List<Categoria> obtenerTodos();

    Page<Categoria> findByNombreContaining(String nombre, Pageable pageable);

    Optional<Categoria> obtenerPorId(Integer id);

    Categoria crearOEditar(Categoria categoria);

    void eliminarPorId(Integer id);

}
