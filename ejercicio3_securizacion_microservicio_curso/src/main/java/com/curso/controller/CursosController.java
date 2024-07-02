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

@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	CursosService service;
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listar() {
		return service.cursos();		
	}
	
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable("codCurso") String codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@PutMapping(value = "curso/{codCurso}/{duracion}")
	public void actualizar(@PathVariable("codCurso") String codString, @PathVariable("duracion") Integer duracion) {
		service.actualizarDuracion(codString, duracion);
	}
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscar(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value = "cursos/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listar(@PathVariable("precioMin") BigDecimal precioMin, @PathVariable("precioMax") BigDecimal precioMax){
		return service.cursosPorPrecio(precioMin, precioMax);
	}
	
	

}
