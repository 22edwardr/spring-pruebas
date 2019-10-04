package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@ApplicationScope
@SessionScope//En este no funciona el predestroy ya que el lifecycle lo maneja el navegador
//@RequestScope
public class Factura implements Serializable {
	private static final long serialVersionUID = 946004357128146951L;
	@Value("${descripcion.factura}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemFactura> items;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" Jose"));
		this.descripcion = this.descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}

	@PreDestroy
	public void destruir() {
		System.out.println("Acabe de destruir el objeto Factura");
	}
}
