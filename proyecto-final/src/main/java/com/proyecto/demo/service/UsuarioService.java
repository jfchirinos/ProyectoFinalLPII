package com.proyecto.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.model.Usuario;
import com.proyecto.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public void registrarUsuario(Usuario Usuario) {
		usuarioRepository.save(Usuario);
    }
	
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}	
}
