package com.example.T26.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="investigadores")

public class Investigadores {

	//Atributos de la entidad Empleado
	@Id
	private String dni;
	private String nomapels;
	
	@OneToMany
	@JoinColumn(name="dnireserva")
	private List<Reservas> reservas;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultades facultades;
	
	//Constructores
	
	public Investigadores() {
		
	}
	
	public Investigadores(String dni, String nomapels, Facultades facultades) {
		this.dni=dni;
		this.nomapels=nomapels;
		this.facultades=facultades;
	}

	//Setters y getters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}
	
	public Facultades getFacultades() {
		return facultades;
	}


	public void setFacultades(Facultades facultades) {
		this.facultades = facultades;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado_A")
	public List<Reservas> getReservas() {
		return reservas;
	}


	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Proyectos [dni = " + dni +", nomapels = " + nomapels +", facultad = " + facultades +" ] ";
	}
}