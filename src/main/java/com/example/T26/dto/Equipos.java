package com.example.T26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="equipos")

public class Equipos {

	//Atributos de la entidad Equipos
	@Id
	private String numserie;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultades facultad;
	
	
	@OneToMany
	@JoinColumn(name="numseriereserva")
	private List<Reservas> reservas;
	
	//Constructores
	
	public Equipos() {
		
	}
	
	public Equipos(String numserie,String nombre, Facultades facultad) {
		this.numserie=numserie;
		this.nombre=nombre;
		this.facultad=facultad;
	}

	//Getters setters
	
	public String getNumserie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultades getFacultades() {
		return facultad;
	}

	public void setFacultades(Facultades facultad) {
		this.facultad = facultad;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reservas")
	public List<Reservas> getReservas() {
		return reservas;
	}




	

	//To string personalizado
	@Override
	public String toString() {
		return "Equipos [numserie = " + numserie +", nombre =" +nombre+ ",facultad = " + facultad +" ] ";
	}
}
