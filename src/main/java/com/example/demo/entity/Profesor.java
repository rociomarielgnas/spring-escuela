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

@ApiModel(description="Entidad que representa un profesor.")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFESOR")
public class Profesor {

	@Id
	@GeneratedValue
	@Column(name="id")
	@ApiModelProperty(notes="El id del profesor")
	private Integer id;
	
	@Column(name="nombre")
	@ApiModelProperty(notes="El nombre del profesor")
	private String nombre;
	
	@Column(name="edad")
	@ApiModelProperty(notes="La edad del profesor")
	private Integer edad;
	
	@Column(name="direccion")
	@ApiModelProperty(notes="La dirección del profesor")
	private String direccion;
	
	@Column(name="email")
	@ApiModelProperty(notes="El mail del profesor")
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
