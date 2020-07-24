package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	Profesor findByNombre(String nombre);
}
