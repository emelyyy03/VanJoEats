package com.example.demo.repositorios;

import com.example.demo.modelos.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlatilloRepository extends JpaRepository<Platillo, Integer>
{

}
