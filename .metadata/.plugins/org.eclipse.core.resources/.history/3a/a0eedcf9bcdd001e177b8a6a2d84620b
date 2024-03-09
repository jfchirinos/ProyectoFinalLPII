package com.proyecto.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presentaciones")
public class Presentacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpresentaciones", nullable = false)
    public Long idpresentaciones;

    @Column(name = "nombre", nullable = false)
    public String nombre;

    // Constructor vacío
    public Presentacion() {
    }

    // Constructor con todos los campos
    public Presentacion(Long idpresentaciones, String nombre) {
        this.idpresentaciones = idpresentaciones;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getIdpresentaciones() {
        return idpresentaciones;
    }

    public void setIdpresentaciones(Long idpresentaciones) {
        this.idpresentaciones = idpresentaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}