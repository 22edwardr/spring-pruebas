package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("Mi servicio simple")
//@Primary//Define a esta implementacion de la interfaz como la importante
public class MiServicio implements IServicio {
	public String operacion() {
		return "ejecutando algun proceso importante";
	}
}
