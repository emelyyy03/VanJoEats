package com.example.demo.servicios.interfaces;

import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    
    List<Usuario> obtenerTodos();

    boolean existsByNombreOrEmailOrFechaRegistroOrRol(String nombre, String email, LocalDate fechaRegistro, Rol rol);
  
    Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContainingAndFechaRegistroAndRol(String nombre, String email, String telefono, LocalDate fechaRegistro, Rol rol, Pageable pageable);

    Optional<Usuario> obtenerPorId(Integer id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Integer id);
}
