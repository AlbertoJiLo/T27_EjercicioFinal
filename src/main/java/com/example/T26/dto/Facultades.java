package com.example.T26.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="facultades")

public class Facultades {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Investigadores> investigadores;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Equipos> equipos;
	
	//Constructores
	
	public Facultades() {
		
	}
	
	public Facultades(Long codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
	}

	//Getters setters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
	public List<Equipos> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
	public List<Investigadores> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigadores> investigadores) {
		this.investigadores = investigadores;
	}
	

	//To string personalizado
	@Override
	public String toString() {
		return "Facultades [codigo = " + codigo +", nombre = " + nombre +" ] ";
	}
}
