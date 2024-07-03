package com.curso.service;

import java.math.BigDecimal;
import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	
	List<Curso> cursos();
	
	void altaCurso(Curso curso);
	
	List<Curso> eliminarCurso(String codCurso);
	
	void actualizarDuracion(String codCurso, Integer duracion);
	
	Curso buscarCurso(String codCurso);
	
	List<Curso> cursosPorPrecio(BigDecimal precioMin, BigDecimal precioMax); 

}
