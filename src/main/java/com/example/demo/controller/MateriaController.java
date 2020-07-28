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
import com.example.demo.entity.Materia;
import com.example.demo.service.MateriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class MateriaController {

	@Autowired
	private MateriaService service;

	@PostMapping("/addMateria")
	@ApiOperation(value = "Agrega una materia", notes = "Se usa para cargar una nueva materia.", response = Materia.class)
	public Materia addMateria(
			@ApiParam(value = "Objeto materia con la info", required = true) @RequestBody Materia materia) {
		return service.saveMateria(materia);
	}

	@PostMapping("/addMaterias")
	@ApiOperation(value = "Agrega varias materias", notes = "Se usa para cargar varias materias al mismo tiempo.", response = List.class)
	public List<Materia> addMaterias(
			@ApiParam(value = "Listado de materias a agregar", required = true) @RequestBody List<Materia> materias) {
		return service.saveMaterias(materias);
	}

	@GetMapping("/materias")
	@ApiOperation(value = "Devuelve todas las materias", notes = "Devuelve un listado de todas las materias de la base.", response = List.class)
	public List<Materia> findAllMaterias() {
		return service.getMaterias();
	}

	@GetMapping("/materiaById/{id}")
	@ApiOperation(value = "Busca una materia por id", notes = "Devuelve una materia (si existe) en base al id.", response = Materia.class)
	public Materia findMateriaById(@ApiParam(value = "El id de la materia", required = true) @PathVariable Integer id) {
		return service.getMateriaById(id);
	}

	@GetMapping("/materias/{nombre}")
	@ApiOperation(value = "Busca una materia por nombre", notes = "Devuelve una materia (si existe) en base al nombre.", response = Materia.class)
	public Materia findMateriaByNombre(
			@ApiParam(value = "El nombre de la materia", required = true) @PathVariable String nombre) {
		return service.getMateriaByNombre(nombre);
	}

	@PutMapping("/updateMateria")
	@ApiOperation(value = "Actualiza info de la materia", notes = "Actualiza la información de una materia en la base.", response = Materia.class)
	public Materia updateMateria(
			@ApiParam(value = "Objeto materia con la info actualizada", required = true) @RequestBody Materia materia) {
		return service.updateMateria(materia);
	}

	@DeleteMapping("/deleteMateria/{id}")
	@ApiOperation(value = "Elimina una materia", notes = "Elimina una materia de la base de datos en base al id.", response = String.class)
	public String deleteMateria(
			@ApiParam(value = "El id de la materia a eliminar", required = true) @PathVariable Integer id) {
		return service.deleteMateria(id);
	}
}
