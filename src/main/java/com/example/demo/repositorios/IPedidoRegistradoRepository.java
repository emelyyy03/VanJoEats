package com.example.demo.repositorios;

import com.example.demo.modelos.PedidoRegistrado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRegistradoRepository extends JpaRepository<PedidoRegistrado, Integer> {

}
