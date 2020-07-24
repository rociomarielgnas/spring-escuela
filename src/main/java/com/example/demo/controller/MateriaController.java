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

import com.example.demo.entity.Materia;
import com.example.demo.service.MateriaService;

@RestController
public class MateriaController {

	@Autowired
	private MateriaService service;

	@PostMapping("/addMateria")
	public Materia addMateria(@RequestBody Materia materia) {
		return service.saveMateria(materia);
	}

	@PostMapping("/addMaterias")
	public List<Materia> addMaterias(@RequestBody List<Materia> materias) {
		return service.saveMaterias(materias);
	}

	@GetMapping("/materias")
	public List<Materia> findAllMaterias() {
		return service.getMaterias();
	}

	@GetMapping("/materiaById/{id}")
	public Materia findMateriaById(@PathVariable Integer id) {
		return service.getMateriaById(id);
	}

	@GetMapping("/materias/{nombre}")
	public Materia findMateriaByNombre(@PathVariable String nombre) {
		return service.getMateriaByNombre(nombre);
	}

	@PutMapping("/updateMateria")
	public Materia updateMateria(@RequestBody Materia materia) {
		return service.updateMateria(materia);
	}

	@DeleteMapping("/deleteMateria")
	public String deleteMateria(@PathVariable Integer id) {
		return service.deleteMateria(id);
	}
}

