package com.proyecto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.demo.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

}