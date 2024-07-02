package com.curso.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {

	List<Curso> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);
	
}
