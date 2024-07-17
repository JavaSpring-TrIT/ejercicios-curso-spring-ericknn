package com.curso.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao cursosDao;
	
	@Override
	public List<Curso> cursos() {
		// TODO Auto-generated method stub
		return cursosDao.findAll();
	}

	@Override
	public void altaCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursosDao.save(curso);
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		// TODO Auto-generated method stub
		cursosDao.deleteById(codCurso);
		return cursos();
	}

	@Override
	public void actualizarDuracion(String codCurso, Integer duracion) {
		// TODO Auto-generated method stub
		Curso curso = buscarCurso(codCurso);
		curso.setDuracion(duracion);
		cursosDao.save(curso);
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		// TODO Auto-generated method stub
		return cursosDao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> cursosPorPrecio(BigDecimal precioMin, BigDecimal precioMax) {
		// TODO Auto-generated method stub
		return cursosDao.findByPrecioBetween(precioMin, precioMax);
	}

}
