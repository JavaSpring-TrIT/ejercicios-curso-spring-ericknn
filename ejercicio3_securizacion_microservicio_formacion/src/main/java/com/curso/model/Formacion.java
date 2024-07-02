package com.curso.model;

import java.math.BigDecimal;

public class Formacion {
	
	private String curso;
	
	private Integer asignaturas;
	
	private BigDecimal precio;	

	public Formacion() {
		super();
	}
	
	public Formacion(String curso, Integer asignaturas, BigDecimal precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Integer asignaturas) {
		this.asignaturas = asignaturas;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	

}
