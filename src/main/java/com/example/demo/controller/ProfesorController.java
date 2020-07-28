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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags={"Profesor"} ) 
@RestController
public class ProfesorController {

	@Autowired
	private ProfesorService service;

	@PostMapping("/addProfesor")
	@ApiOperation(value = "Agrega un profesor", notes = "Se usa para cargar un nuevo profesor.", response = Profesor.class)
	public Profesor addProfesor(
			@ApiParam(value = "Objeto profesor con la info", required = true) @RequestBody Profesor profesor) {
		return service.saveProfesor(profesor);
	}

	@PostMapping("/addProfesores")
	@ApiOperation(value = "Agrega un conjunto de profesores", notes = "Se usa para cargar un conjunto de profesores al mismo tiempo.", response = List.class)
	public List<Profesor> addProfesores(
			@ApiParam(value = "Lista de profesores", required = true) @RequestBody List<Profesor> profesores) {
		return service.saveProfesores(profesores);
	}

	@GetMapping("/profesores")
	@ApiOperation(value = "Devuelve un listado con todos los profesores", notes = "Devuelve una lista con todos los profesores en la base.", response = Profesor.class)
	public List<Profesor> findAllProfesores() {
		return service.getProfesores();
	}

	@GetMapping("/profesorById/{id}")
	@ApiOperation(value = "Busca un profesor por id", notes = "Busca un profesor en la base en base al id.", response = Profesor.class)
	public Profesor findProfesorById(
			@ApiParam(value = "El id del profesor", required = true) @PathVariable Integer id) {
		return service.getProfesorById(id);
	}

	@GetMapping("/profesores/{nombre}")
	@ApiOperation(value = "Busca un profesor por nombre", notes = "Busca un profesor en la base en base al nombre.", response = Profesor.class)
	public Profesor findProfesorByNombre(
			@ApiParam(value = "El nombre del profesor", required = true) @PathVariable String nombre) {
		return service.getProfesorByNombre(nombre);
	}

	@PutMapping("/updateProfesor")
	@ApiOperation(value = "Actualiza info del profesor", notes = "Actualiza la info del profesor en la base de datos.", response = Profesor.class)
	public Profesor updateProfesor(
			@ApiParam(value = "Objeto profesor con la info", required = true) @RequestBody Profesor profesor) {
		return service.updateProfesor(profesor);
	}

	@DeleteMapping("/deleteProfesor/{id}")
	@ApiOperation(value = "Elimina un profesor", notes = "Elimina un profesor de la base de datos en base al id.", response = String.class)
	public String deleteProfesor(@ApiParam(value = "El id del profesor", required = true) @PathVariable Integer id) {
		return service.deleteProfesor(id);
	}
}
