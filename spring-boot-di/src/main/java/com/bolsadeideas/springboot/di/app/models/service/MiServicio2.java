package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

//@Service("Mi servicio complejo2")
public class MiServicio2 implements IServicio {
	public String operacion() {
		return "ejecutando algun proceso importante2";
	}
}
