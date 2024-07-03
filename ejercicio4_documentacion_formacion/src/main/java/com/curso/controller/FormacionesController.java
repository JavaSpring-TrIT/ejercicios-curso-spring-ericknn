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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@CrossOrigin("*")
@RestController
public class FormacionesController {
	
	@Autowired
	FormacionesService service;
	
	@Operation(summary="Devuelve todas las formaciones.", description="Devuelve el catalogo de formaciones completo.")
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listar() {
		return service.formaciones();		
	}
	
	@Operation(summary="Da de alta una formación nueva.", description="Almacena la información de una nueva formación que se envía en el cuerpo de la petición.")
	@PostMapping(value="formacion", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Formación a dar de alta.", required = true,content = @Content(schema=@Schema(implementation = Formacion.class))) @RequestBody Formacion formacion) {
		service.altaFormacion(formacion);
	}
	
	
}
