package com.curso.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	CursosService service;
	
	@Operation(summary="Devuelve todos los cursos.", description="Devuelve el catalogo de cursos completo.")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listar() {
		return service.cursos();		
	}
	
	@Operation(summary="Da de alta un curso nuevo.", description="Almacena la información de un nuevo curso que se envía en el cuerpo de la petición.")
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)	
	public void agregar(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Curso a dar de alta.", required = true,content = @Content(schema=@Schema(implementation = Curso.class))) @RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	@Operation(summary="Dar de baja un curso.", description="Elimina la información de un curso existente.")
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@Parameter(description = "Variable que contiene el codigo del curso a eliminar.") @PathVariable("codCurso") String codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@Operation(summary="Actualiza la duración de un curso.", description="Modifica la duración de un curso existente.")
	@PutMapping(value = "curso/{codCurso}/{duracion}")
	public void actualizar(@Parameter(description = "Variable que contiene el codigo del curso a actualizar.") @PathVariable("codCurso") String codString, @Parameter(description = "Variable que contiene la nueva duración.") @PathVariable("duracion") Integer duracion) {
		service.actualizarDuracion(codString, duracion);
	}
	
	@Operation(summary="Busca un curso por el codigo.", description="Localiza un curso a partir de un codigo de curso.")
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscar(@Parameter(description = "Variable que contiene el codigo del curso a buscar.") @PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@Operation(summary="Devuelve los cursos entre un rango de precios.", description="Localiza los cursos a que se encuentren en un rango minimo y maximo de precio.")
	@GetMapping(value = "cursos/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listar(@Parameter(description = "Variable que contiene el rango minimo de precio.") @PathVariable("precioMin") BigDecimal precioMin, @Parameter(description = "Variable que contiene el rango maximo de precio.") @PathVariable("precioMax") BigDecimal precioMax){
		return service.cursosPorPrecio(precioMin, precioMax);
	}
	
	

}
