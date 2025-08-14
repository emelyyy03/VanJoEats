package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Categoria;
import com.example.demo.repositorios.ICategoriaRepository;
import com.example.demo.servicios.interfaces.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Page<Categoria> findByNombreContaining(String nombre, Pageable pageable) {
        return categoriaRepository.findByNombreContaining(nombre, pageable);
    }

    @Override
    public Categoria obtenerPorId(Integer id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria crearOEditar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
