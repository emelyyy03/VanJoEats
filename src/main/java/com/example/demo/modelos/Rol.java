package com.example.demo.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Rol {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer Id;

@NotBlank(message = "El nombre de rol es obligatorio")
private String nombre;

@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Set<Usuario> usuario = new HashSet<>();

public Integer getId() {
    return Id;
}

public void setId(Integer id) {
    Id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}



}
