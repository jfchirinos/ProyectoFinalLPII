package com.proyecto.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo.model.Rol;
import com.proyecto.demo.model.Usuario;
import com.proyecto.demo.service.RolService;
import com.proyecto.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/usuarios")
	public String getAllUsuarios(Model model) {
        List<Usuario> lisUsuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", lisUsuarios); 
        return "usuarioList";  
    }
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("roles", rolService.getAllRoles());
		return "usuarioRegister";
	}
		
	@PostMapping("/register")
	public String registerUsuario(@RequestParam("nombres") String nombres,
	                                @RequestParam("primerApellido") String primerApellido,
	                                @RequestParam("segundoApellido") String segundoApellido,
	                                @RequestParam("email") String email,
	                                @RequestParam("password") String password,
	                                @RequestParam("idroles") Long idRol, 
	                                Model model) {
		
	    Rol rol = rolService.getRolById(idRol);
	    
	    Usuario usuario = new Usuario();
	    usuario.setNombres(nombres);
	    usuario.setPrimerApellido(primerApellido);
	    usuario.setSegundoApellido(segundoApellido);
	    usuario.setEmail(email);
	    usuario.setPassword(password);
	    usuario.setRol(rol);
	    
	    usuarioService.registrarUsuario(usuario);
	    
	    List<Usuario> listUsuarios = usuarioService.getAllUsuarios();
		model.addAttribute("usuarios", listUsuarios);

	    return "usuarioList"; 
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
	    Usuario usuario = usuarioService.getUsuarioById(id);
	    model.addAttribute("usuario", usuario);
	    model.addAttribute("roles", rolService.getAllRoles());
	    return "usuarioEdit";
	}
		
	@PostMapping("/edit")
	public String editUsuario(@RequestParam("id") Long id,
								@RequestParam("nombres") String nombres,
								@RequestParam("primerApellido") String primerApellido,
					            @RequestParam("segundoApellido") String segundoApellido,
					            @RequestParam("email") String email,
					            @RequestParam("password") String password,
					            @RequestParam("idroles") Long idRol, 
	                            Model model) {

	    Rol rol = rolService.getRolById(idRol);
	    
	    Usuario usuario = usuarioService.getUsuarioById(id);
	    usuario.setNombres(nombres);
	    usuario.setPrimerApellido(primerApellido);
	    usuario.setSegundoApellido(segundoApellido);
	    usuario.setEmail(email);
	    usuario.setPassword(password);
	    usuario.setRol(rol);

	    usuarioService.registrarUsuario(usuario);

	    List<Usuario> listUsuarios = usuarioService.getAllUsuarios();
	    model.addAttribute("usuarios", listUsuarios);

	    return "usuarioList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		usuarioService.eliminarUsuario(id);
		
		List<Usuario> listUsuarios = usuarioService.getAllUsuarios();
	    model.addAttribute("usuarios", listUsuarios);
		
		return "usuarioList";
	}
}