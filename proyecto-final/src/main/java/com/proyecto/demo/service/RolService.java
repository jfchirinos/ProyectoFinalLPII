package com.proyecto.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.demo.model.Rol;
import com.proyecto.demo.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> getAllRoles(){
		return rolRepository.findAll();
	}
	public Rol getRolById(Long id) {
        Optional<Rol> RolOptional = rolRepository.findById(id);
        return RolOptional.orElse(null);
    }
}
