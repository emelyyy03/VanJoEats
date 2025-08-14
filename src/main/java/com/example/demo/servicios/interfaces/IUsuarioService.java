package com.example.demo.servicios.interfaces;

import com.example.demo.modelos.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IUsuarioService {
    
    List<Usuario> obtenerTodos();

    boolean existsByNombreOrEmailOrFechaRegistroOrRol(String nombre, String email, Date fechaRegistro, String rol);
  
    Page<Usuario> findByNombreContainingAndEmailContainingAndFechaRegistroContainingAndRolContaining(String nombre, String email, Date fechaRegistro, String rol, Pageable pageable);

    Usuario obtenerPorId(Integer id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Integer id);
}
