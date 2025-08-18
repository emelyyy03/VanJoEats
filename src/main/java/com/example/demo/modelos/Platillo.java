package com.example.demo.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class Platillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del platillo es obligatorio")
    private String nombre;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private int cantidad;

    @Column(name = "imagen_platillo", nullable = false, length = 255)
    @NotBlank(message = "Debe proporcionar una imagen")
    private String imagenPlatillo;
    /*
     * @NotBlank(message = "Debe proporcionar una imagen")
     * private String imagen;
     */

    @DecimalMin(value = "0.00", message = "El precio no puede ser negativo")
    @Digits(integer = 6, fraction = 2, message = "El precio debe tener como máximo 2 decimales")
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @Min(value = 0, message = "La disponibilidad no puede ser negativa")
    private int disponibilidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagenPlatillo() {
        return imagenPlatillo;
    }

    public void setImagenPlatillo(String imagenPlatillo) {
        this.imagenPlatillo = imagenPlatillo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
