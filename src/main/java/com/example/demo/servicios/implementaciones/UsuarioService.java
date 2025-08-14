package com.example.demo.servicios.implementaciones;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.IUsuarioRepository;
import com.example.demo.servicios.interfaces.IUsuarioService;

public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario crearOEditar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Page<Usuario> findByNombreContainingAndEmailContainingAndFechaRegistroContainingAndRolContaining(
            String nombre, String email, Date fechaRegistro, String rol, Pageable pageable) {
        return usuarioRepository.findByNombreContainingAndEmailContainingAndFechaRegistroContainingAndRolContaining(
                nombre, email, fechaRegistro, rol, pageable);

    }

    @Override
    public boolean existsByNombreOrEmailOrFechaRegistroOrRol(String nombre, String email, Date fechaRegistro,
            String rol) {
        return usuarioRepository.existsByNombreOrEmailOrFechaRegistroOrRol(nombre, email, fechaRegistro, rol);
    }

}
