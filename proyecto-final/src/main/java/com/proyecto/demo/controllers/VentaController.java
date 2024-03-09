package com.proyecto.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.demo.model.Venta;
import com.proyecto.demo.service.VentaService;
import java.util.List;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	 @Autowired
    private VentaService ventaService;

    @GetMapping("/ventas")
    public String getAllVentas(Model model) {
        List<Venta> ventas = ventaService.getAllVentas();
        model.addAttribute("ventas", ventas);
        return "ventaList";
    }
}
