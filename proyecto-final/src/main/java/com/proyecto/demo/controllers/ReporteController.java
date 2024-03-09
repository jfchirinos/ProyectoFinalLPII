package com.proyecto.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.demo.model.Venta;
import com.proyecto.demo.service.VentaService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReporteController {
	
	@Autowired
	private VentaService ventaService;

	@GetMapping("/report")
	public void report(HttpServletResponse response) throws JRException, IOException {
		
		// 1. Acceder al reporte 
		InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/Reporte_ventas_proyecto.jasper");

		// 2. Preparar los datos 	
		List<Venta> ventas = ventaService.getAllVentas();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ventas);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
	
		// 3. Configuracion 
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "filename=reporte_ventas.pdf");		

		// 4. Exportar reporte
		final OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);	

	}
}