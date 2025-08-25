package com.example.demo.repositorios;
import com.example.demo.modelos.Usuario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByNombreOrEmail(String nombre, String email);

    Page<Usuario> findByNombreContainingAndEmailContainingAndTelefonoContaining(
        String nombre, String email, String telefono, Pageable pageable);
}
