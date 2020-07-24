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

import com.example.demo.entity.Profesor;
import com.example.demo.service.ProfesorService;

@RestController
public class ProfesorController {

	@Autowired
	private ProfesorService service;

	@PostMapping("/addProfesor")
	public Profesor addProfesor(@RequestBody Profesor profesor) {
		return service.saveProfesor(profesor);
	}

	@PostMapping("/addProfesores")
	public List<Profesor> addProfesores(@RequestBody List<Profesor> profesores) {
		return service.saveProfesores(profesores);
	}

	@GetMapping("/profesores")
	public List<Profesor> findAllProfesores() {
		return service.getProfesores();
	}

	@GetMapping("/profesorById/{id}")
	public Profesor findProfesorById(@PathVariable Integer id) {
		return service.getProfesorById(id);
	}

	@GetMapping("/profesores/{nombre}")
	public Profesor findProfesorByNombre(@PathVariable String nombre) {
		return service.getProfesorByNombre(nombre);
	}

	@PutMapping("/updateProfesor")
	public Profesor updateProfesor(@RequestBody Profesor profesor) {
		return service.updateProfesor(profesor);
	}

	@DeleteMapping("/deleteProfesor")
	public String deleteProfesor(@PathVariable Integer id) {
		return service.deleteProfesor(id);
	}
}

