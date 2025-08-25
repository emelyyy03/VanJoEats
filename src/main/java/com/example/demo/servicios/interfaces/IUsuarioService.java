package com.example.demo.servicios.interfaces;

import com.example.demo.modelos.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    
    List<Usuario> obtenerTodos();

    boolean existsByNombreOrEmail(String nombre, String email);
  
    Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContaining(String nombre, String email, String telefono, Pageable pageable);

    Optional<Usuario> obtenerPorId(Integer id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Integer id);
}
