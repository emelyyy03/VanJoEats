package com.example.demo.repositorios;

import com.example.demo.modelos.Platillo;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlatilloRepository extends JpaRepository<Platillo, Integer> {
    Page<Platillo> findByNombreContainingAndPrecioContainingAndCategoriaContaining(String nombre, BigDecimal precio,
            String categoria, Pageable pageable);
}
