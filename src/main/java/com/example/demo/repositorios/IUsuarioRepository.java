package com.example.demo.repositorios;

import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByNombreOrEmailOrFechaRegistroOrRol(String nombre, String email, Date fechaRegistro, Rol rol);

    Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContainingAndFechaRegistroAndRolContaining(
        String nombre, String email, String telefono, Date fechaRegistro, Rol rol, Pageable pageable);
}
