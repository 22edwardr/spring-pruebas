package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {

	@GetMapping("/string/{texto}")
	public String variables(@PathVariable(name="texto") String texto,Model model) { //podria ser solo @PathVariable si la variable se llama igual 
		model.addAttribute("resultado","El texto obtenido de la ruta es: " + texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables2(@PathVariable(name="texto") String texto,@PathVariable Integer numero,Model model) { //podria ser solo @PathVariable si la variable se llama igual 
		model.addAttribute("resultado","El texto obtenido de la ruta es: " + texto + " y el numero enviado en el path es: " + numero);
		return "variables/ver";
	}
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo","Enviar parametros ruta");
		
		return "variables/index";
	}
}
