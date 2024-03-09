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

import com.proyecto.demo.model.Presentacion;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.PresentacionService;
import com.proyecto.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private PresentacionService presentacionService;
	
	@GetMapping("/productos")
	public String getAllproductos(Model model) {
        List<Producto> lisproductos = productoService.getAllProductos();
        model.addAttribute("productos", lisproductos); 
        return "productoList";  
    }
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("presentaciones", presentacionService.getAllPresentaciones());
	    return "productoRegister";
	}
	@PostMapping("/register")
	public String registerUsuario(@RequestParam("nombre") String nombre,
									 @RequestParam("descripcion") String descripcion,
						             @RequestParam("precio") Double precio,
						             @RequestParam("idpresentaciones") Long idPresentacion,
	                                Model model) {
		
		Presentacion presentacion = presentacionService.getPresentacionById(idPresentacion);
	    
	    Producto producto = new Producto();
	    producto.setNombre(nombre);
	    producto.setDescripcion(descripcion);	
	    producto.setPrecio(precio);	
	    producto.setPresentacion(presentacion);
	    
	    productoService.registrarProducto(producto);
	    
	    List<Producto> listProductos = productoService.getAllProductos();
		model.addAttribute("productos", listProductos);

	    return "productoList"; 
	}	

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Producto producto = productoService.getProductoById(id);
	    model.addAttribute("producto", producto);
	    model.addAttribute("presentaciones", presentacionService.getAllPresentaciones());
	    return "productoEdit";
	}
		
	@PostMapping("/edit")
	public String editproducto(@RequestParam("id") Long id,
								@RequestParam("nombre") String nombre,
					            @RequestParam("descripcion") String descripcion,
					            @RequestParam("precio") Double precio,
					            @RequestParam("idpresentaciones") Long idPresentacion, 
	                            Model model) {

	    Presentacion presentacion = presentacionService.getPresentacionById(idPresentacion);

	    Producto producto = productoService.getProductoById(id);
	    producto.setNombre(nombre);
	    producto.setDescripcion(descripcion);	
	    producto.setPrecio(precio);	
	    producto.setPresentacion(presentacion);

	    productoService.registrarProducto(producto);

	    List<Producto> listproductos = productoService.getAllProductos();
	    model.addAttribute("productos", listproductos);

	    return "productoList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		productoService.eliminarProducto(id);
		
		List<Producto> listproductos = productoService.getAllProductos();
	    model.addAttribute("productos", listproductos);
		
		return "productoList";
	}
}

