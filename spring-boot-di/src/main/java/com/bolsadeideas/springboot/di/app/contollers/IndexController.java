package com.bolsadeideas.springboot.di.app.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {

	@Qualifier("miServicioSimple")
	@Autowired // Cuando se hace en constructor incluso se puede obviar la anotacion
	private IServicio lms_servicio;
	
	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("objeto", lms_servicio.operacion()); 
		
		return "index";
	}
	
	

}
