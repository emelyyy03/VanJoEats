package com.example.demo.repositorios;

import com.example.demo.modelos.Categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
    Page<Categoria> findByNombreContaining(String nombre, Pageable pageable);
}
