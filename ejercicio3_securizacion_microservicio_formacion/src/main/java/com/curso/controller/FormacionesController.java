package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

@CrossOrigin("*")
@RestController
public class FormacionesController {
	
	@Autowired
	FormacionesService service;
	
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listar() {
		return service.formaciones();		
	}
	
	@PostMapping(value="formacion", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Formacion formacion) {
		service.altaFormacion(formacion);
	}
	
	
}
