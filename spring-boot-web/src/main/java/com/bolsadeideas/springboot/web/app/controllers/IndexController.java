package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexController.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexController.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "/home", "" })
	public String index(Model model) {// ModelMap o Map o ModelAndView->Este ultimo deja especificar la vista y modelo
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setApellido("Andres");
		usuario.setNombre("Andres2");
		usuario.setEmail("a@a.com");

		model.addAttribute("titulo", textoPerfil + usuario.getNombre());
		model.addAttribute("usuario", usuario);
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios") // Añade un atributo para todos los handlers de este controlador, muy util para
								// poblar selects o radiobuttons
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("A", "A", "A@A.COM"), new Usuario("B", "B", "B@B.COM"),
				new Usuario("C", "C", "C@C.COM"));

		return usuarios;
	}

}
