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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags={"Alumno"} ) 
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@PostMapping("/addAlumno")
	@ApiOperation(value = "Agrega un alumno", notes = "Se usa para cargar un nuevo alumno.", response = Alumno.class)
	public Alumno addAlumno(
			@ApiParam(value = "Objeto alumno con la info", required = true) @RequestBody Alumno alumno) {
		return service.saveAlumno(alumno);
	}

	@PostMapping("/addAlumnos")
	@ApiOperation(value = "Agrega una cantidad de alumnos", notes = "Se usa para cargar varios alumnos al mismo tiempo.", response = List.class)
	public List<Alumno> addAlumnos(
			@ApiParam(value = "Listado de alumnos", required = true) @RequestBody List<Alumno> alumnos) {
		return service.saveAlumnos(alumnos);
	}

	@GetMapping("/alumnos")
	@ApiOperation(value = "Devuelve la lista de alumnos", notes = "Devuelve una lista con todos los alumnos cargados.", response = List.class)
	public List<Alumno> findAllAlumnos() {
		return service.getAlumnos();
	}

	@GetMapping("/alumnoById/{id}")
	@ApiOperation(value = "Devuelve un alumno específico en base al id", notes = "Busca un alumno por id y lo devuelve.", response = Alumno.class)
	public Alumno findAlumnoById(@ApiParam(value = "El id del alumno", required = true) @PathVariable Integer id) {
		return service.getAlumnoById(id);
	}

	@GetMapping("/alumnos/{nombre}")
	@ApiOperation(value = "Busca un alumno por el nombre", notes = "Devuelve un alumno si se encontró en base a nombre.", response = Alumno.class)
	public Alumno findAlumnoByNombre(
			@ApiParam(value = "El nombre del alumno", required = true) @PathVariable String nombre) {
		return service.getAlumnoByNombre(nombre);
	}

	@PutMapping("/updateAlumno")
	@ApiOperation(value = "Actualiza la info de un alumno", notes = "Actualiza la información en la base para un alumno", response = Alumno.class)
	public Alumno updateAlumno(
			@ApiParam(value = "Objeto alumno con la info actualizada", required = true) @RequestBody Alumno alumno) {
		return service.updateAlumno(alumno);
	}

	@DeleteMapping("/deleteAlumno/{id}")
	@ApiOperation(value = "Elimina un alumno en base al id", notes = "Elimina un registro en la tabla de alumnos en base al id.", response = Alumno.class)
	public String deleteAlumno(
			@ApiParam(value = "El id del alumno a eliminar", required = true) @PathVariable Integer id) {
		return service.deleteAlumno(id);
	}
}
