package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {

		return "params/index";

	}

	@GetMapping("/string")
	public String param(
			@RequestParam(defaultValue = "Valor por defecto", required = false, name = "texto") String texto,
			Model model) { // == @RequestParam en este caso el nombre de la variable es el mismo
		model.addAttribute("resultado", "El parametro enviado es: " + texto);

		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) { // == @RequestParam
																									// en este caso el
																									// nombre de la
																									// variable es el
																									// mismo
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero: '" + numero + "'");

		return "params/ver";
	}

	@GetMapping("/mix-params2")
	public String param(HttpServletRequest request, Model model) { // Tambien se puede obtener el objeto HttpServletRequest
		model.addAttribute("resultado", "El saludo enviado es: '" + request.getParameter("saludo") + "' y el numero: '"
				+ request.getParameter("numero") + "'");

		return "params/ver";
	}

}
