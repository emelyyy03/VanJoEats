package com.example.demo.servicios.implementaciones;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Categoria;
import com.example.demo.modelos.Platillo;
import com.example.demo.repositorios.IPlatilloRepository;
import com.example.demo.servicios.interfaces.IPlatilloService;

@Service
public class PlatilloService implements IPlatilloService {

    @Autowired
    private IPlatilloRepository platilloRepository;

    @Override
    public List<Platillo> obtenerTodos() {
        return platilloRepository.findAll();
    }

    @Override
    public Page<Platillo> findByNombreContainingAndPrecioAndCategoria(String nombre,
            BigDecimal precio, Categoria categoria, Pageable pageable) {
        return platilloRepository.findByNombreContainingAndPrecioAndCategoria(nombre, precio,
                categoria, pageable);
    }

    @Override
    public Optional<Platillo> obtenerPorId(Integer id) {
        return platilloRepository.findById(id);
    }

    @Override
    public Platillo crearOEditar(Platillo platillo) {
        return platilloRepository.save(platillo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        platilloRepository.deleteById(id);
    }

}
