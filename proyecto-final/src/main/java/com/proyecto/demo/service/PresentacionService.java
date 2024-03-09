package com.proyecto.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.demo.model.Presentacion;
import com.proyecto.demo.repository.PresentacionRepository;

@Service
public class PresentacionService {
	
	@Autowired
	private PresentacionRepository presentacionRepository;
	
	public List<Presentacion> getAllPresentaciones(){
		return presentacionRepository.findAll();
	}
	public Presentacion getPresentacionById(Long id) {
        Optional<Presentacion> PresentacionOptional = presentacionRepository.findById(id);
        return PresentacionOptional.orElse(null);
    }
}