package com.proyecto.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto", nullable = false)
    public Long idproducto;

    @Column(name = "nombre", nullable = false)
    public String nombre;

    @Column(name = "descripcion", nullable = false)
    public String descripcion;

    @Column(name = "precio", nullable = false)
    public double precio;

    @ManyToOne
    @JoinColumn(name = "idpresentaciones", nullable = false)
    public Presentacion presentacion;
    

    // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los campos
    public Producto(Long idproducto, String nombre, String descripcion, double precio, Presentacion presentacion) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.presentacion = presentacion;
    }

    // Getters y Setters
    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }
}
