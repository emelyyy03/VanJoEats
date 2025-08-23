package com.example.demo.servicios.implementaciones;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Rol;
import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.IUsuarioRepository;
import com.example.demo.servicios.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
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
    public Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContainingAndFechaRegistroAndRol(
            String nombre, String email, String telefono, Date fechaRegistro, Rol rol, Pageable pageable) {
        return usuarioRepository.findByNombreContainingAndEmailContainingAndTelefonoContainingAndFechaRegistroAndRol(
                nombre, email, telefono, fechaRegistro, rol, pageable);

    }

    @Override
    public boolean existsByNombreOrEmailOrFechaRegistroOrRol(String nombre, String email, Date fechaRegistro,
            Rol rol) {
        return usuarioRepository.existsByNombreOrEmailOrFechaRegistroOrRol(nombre, email, fechaRegistro, rol);
    }

}
