package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Rol;
import com.example.demo.repositorios.IRolRepository;
import com.example.demo.servicios.interfaces.IRolService;

@Service
public class RolService implements IRolService {

     @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

}
