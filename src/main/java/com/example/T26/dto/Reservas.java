package com.example.T26.dto;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reserva")
public class Reservas{
	
	

	//Atributos de la entidad Empleado

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date comienzo;
	private Date fin;
	
	@ManyToOne
	@JoinColumn(name="numseriereserva")
	private Equipos equipos;
	
	@ManyToOne
	@JoinColumn(name="dnireserva")
	private Investigadores investigadores;
	
	
	
	//Constructores
	
	public Reservas() {
		
	}
	
	public Reservas(Long id,Equipos equipos, Investigadores investigadores, Date comienzo, Date fin) {
		this.id=id;
		this.equipos=equipos;
		this.investigadores=investigadores;
		this.comienzo=comienzo;
		this.fin=fin;
	}

	//Setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public Investigadores getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(Investigadores investigadores) {
		this.investigadores = investigadores;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Reservas [id = " +id+ ",equipos = " + equipos +", investigadores = " + investigadores +" ] ";
	}

	

}
