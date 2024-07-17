package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.curso.model.Curso;
import com.curso.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {
	
	@Autowired
	RestClient restClient;
	
	@Value("${app.user}")
	String user;
	@Value("${app.pass}")
	String pass;
	
	private String url="http://servicio-cursos/";
	
	@Override
	public List<Formacion> formaciones() {
		return getFormaciones(url+"cursos");		
	}
	
	@Override
	public void altaFormacion(Formacion formacion) {
		postFormacion(url+"curso", formacion);
	}

	private void postFormacion(String url, Formacion formacion) {
		Curso curso = new Curso();
		
		curso.setNombre(formacion.getCurso());
		curso.setDuracion(formacion.getAsignaturas()*10);
		curso.setPrecio(formacion.getPrecio());			
		curso.setCodCurso(curso.getNombre().substring(0, 3)+curso.getDuracion());
		
		restClient.post()
		.uri(url)
		.accept(MediaType.APPLICATION_JSON)
		.body(curso)
		.header("Authorization", "Basic "+getBase64(user, pass))
		.retrieve()
		.toBodilessEntity();	
	}
	
	private List<Formacion> getFormaciones(String url) {
		List<Curso> cursos = Arrays.asList(restClient.get()
				.uri(url)
				.header("Authorization", "Basic "+getBase64(user, pass))
				.retrieve()
				.body(Curso[].class));
		List<Formacion> formaciones = new ArrayList<Formacion>();
		for(Curso curso: cursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getNombre());
			formacion.setPrecio(curso.getPrecio());
			formacion.setAsignaturas(curso.getDuracion()>=50 ? 10 : 5);
			formaciones.add(formacion);
		}				
		return formaciones;
	}
	
	private String getBase64(String user, String password) {
		String cad=user+":"+password;
		return Base64.getEncoder().encodeToString(cad.getBytes());
	}
	
	

}
