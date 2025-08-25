package com.example.demo.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
    public Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContaining(
            String nombre, String email, String telefono, Pageable pageable) {
        return usuarioRepository.findByNombreContainingAndEmailContainingAndTelefonoContaining(
                nombre, email, telefono, pageable);

    }

    @Override
    public boolean existsByNombreOrEmail(String nombre, String email) {
        return usuarioRepository.existsByNombreOrEmail(nombre, email);
    }

}
