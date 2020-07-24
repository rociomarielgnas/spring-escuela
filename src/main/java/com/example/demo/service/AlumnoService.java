package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	public Alumno saveAlumno(Alumno alumno) {
		return repository.save(alumno);
	}

	public List<Alumno> saveAlumnos(List<Alumno> alumnos) {
		return repository.saveAll(alumnos);
	}

	public List<Alumno> getAlumnos() {
		return repository.findAll();
	}

	public Alumno getAlumnoById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Alumno getAlumnoByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public String deleteAlumno(Integer id) {
		repository.deleteById(id);
		return "Alumno borrado: " + id;
	}

	public Alumno updateAlumno(Alumno alumno) {
		Alumno existingAlumno = repository.findById(alumno.getId()).orElse(null);
		existingAlumno.setNombre(alumno.getNombre());
		existingAlumno.setDireccion(alumno.getDireccion());
		existingAlumno.setEdad(alumno.getEdad());
		existingAlumno.setEmail(alumno.getEmail());
		return repository.save(existingAlumno);
	}
}
