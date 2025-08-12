package com.example.demo.repositorios;

import com.example.demo.modelos.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Page<Usuario> findByNombreContaining(String nombre, Pageable pageable);
}
