package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoService;

@RestController
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@PostMapping("/addAlumno")
	public Alumno addAlumno(@RequestBody Alumno alumno) {
		return service.saveAlumno(alumno);
	}

	@PostMapping("/addAlumnos")
	public List<Alumno> addAlumnos(@RequestBody List<Alumno> alumnos) {
		return service.saveAlumnos(alumnos);
	}

	@GetMapping("/alumnos")
	public List<Alumno> findAllAlumnos() {
		return service.getAlumnos();
	}

	@GetMapping("/alumnoById/{id}")
	public Alumno findAlumnoById(@PathVariable Integer id) {
		return service.getAlumnoById(id);
	}

	@GetMapping("/alumnos/{nombre}")
	public Alumno findAlumnoByNombre(@PathVariable String nombre) {
		return service.getAlumnoByNombre(nombre);
	}

	@PutMapping("/updateAlumno")
	public Alumno updateAlumno(@RequestBody Alumno alumno) {
		return service.updateAlumno(alumno);
	}

	@DeleteMapping("/deleteAlumno")
	public String deleteAlumno(@PathVariable Integer id) {
		return service.deleteAlumno(id);
	}
}

