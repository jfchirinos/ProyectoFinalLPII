package com.proyecto.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.model.Venta;
import com.proyecto.demo.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}
}
