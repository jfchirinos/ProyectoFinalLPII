package com.proyecto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}