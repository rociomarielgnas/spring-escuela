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

@ApiModel(description="Entidad que representa una materia.")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MATERIA")
public class Materia {
	@Id
	@GeneratedValue
	@Column(name="id")
	@ApiModelProperty(notes="El id de la materia")
	private Integer id;
	
	@Column(name="nombre")
	@ApiModelProperty(notes="El nombre de la materia")
	private String nombre;
	
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
