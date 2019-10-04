package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio2;

@Configuration
public class AppConfig {
	
	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicio2();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto lp_producto1 = new Producto("Prod1", 100);
		Producto lp_producto2 = new Producto("Prod2", 200);
		
		ItemFactura linea1 = new ItemFactura(lp_producto1, 2);
		ItemFactura linea2 = new ItemFactura(lp_producto2, 4);
		
		return Arrays.asList(linea1,linea2);
	}
}
