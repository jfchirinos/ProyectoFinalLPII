package com.proyecto.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	
	public void registrarProducto(Producto Producto) {
		productoRepository.save(Producto);
    }
	
	public Producto getProductoById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}	
}
