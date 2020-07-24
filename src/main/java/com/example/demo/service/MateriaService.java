package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Materia;
import com.example.demo.repository.MateriaRepository;

@Service
public class MateriaService {
	@Autowired
	private MateriaRepository repository;

	public Materia saveMateria(Materia materia) {
		return repository.save(materia);
	}

	public List<Materia> saveMaterias(List<Materia> materias) {
		return repository.saveAll(materias);
	}

	public List<Materia> getMaterias() {
		return repository.findAll();
	}

	public Materia getMateriaById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Materia getMateriaByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public String deleteMateria(Integer id) {
		repository.deleteById(id);
		return "Materia borrada: " + id;
	}

	public Materia updateMateria(Materia materia) {
		Materia existingMateria = repository.findById(materia.getId()).orElse(null);
		existingMateria.setNombre(materia.getNombre());
		return repository.save(existingMateria);
	}
}
