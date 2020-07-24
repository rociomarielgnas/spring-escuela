package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profesor;
import com.example.demo.repository.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorRepository repository;

	public Profesor saveProfesor(Profesor profesor) {
		return repository.save(profesor);
	}

	public List<Profesor> saveProfesores(List<Profesor> profesores) {
		return repository.saveAll(profesores);
	}

	public List<Profesor> getProfesores() {
		return repository.findAll();
	}

	public Profesor getProfesorById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Profesor getProfesorByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public String deleteProfesor(Integer id) {
		repository.deleteById(id);
		return "Profesor borrado: " + id;
	}

	public Profesor updateProfesor(Profesor profesor) {
		Profesor existingProfesor = repository.findById(profesor.getId()).orElse(null);
		existingProfesor.setNombre(profesor.getNombre());
		existingProfesor.setEdad(profesor.getEdad());
		existingProfesor.setEmail(profesor.getEmail());
		existingProfesor.setDireccion(profesor.getDireccion());
		return repository.save(existingProfesor);
	}
}
