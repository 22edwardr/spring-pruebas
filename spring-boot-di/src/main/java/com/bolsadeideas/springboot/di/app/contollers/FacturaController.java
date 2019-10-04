package com.bolsadeideas.springboot.di.app.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	private Factura factura;
	@GetMapping("/ver")
	public String ver(Model model) {
		model.addAttribute("titulo","Ejemplo factura con DI");
		model.addAttribute("factura",factura);
		return "factura/ver";
	}
}
