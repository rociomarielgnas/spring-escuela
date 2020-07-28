package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@ApiModel(description="Entidad que representa un alumno.")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALUMNO")
public class Alumno {

	@Id
	@GeneratedValue
	@Column(name="id")
	@ApiModelProperty(notes="El id del alumno")
	private Integer id;

	@Column(name="nombre")
	@ApiModelProperty(notes="El nombre del alumno")
	private String nombre;
	
	@Column(name="edad")
	@ApiModelProperty(notes="La edad del alumno")
	private Integer edad;
	
	@Column(name="direccion")
	@ApiModelProperty(notes="La dirección del alumno")
	private String direccion;
	
	@Column(name="email")
	@ApiModelProperty(notes="El mail del alumno")
	private String email;
	
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
