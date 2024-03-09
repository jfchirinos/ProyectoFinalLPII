package com.proyecto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

