package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Equipos;

public interface EquiposService {

	//Metodos del CRUD
	
	public List<Equipos> listarEquipos(); //Listar All 
	
	public Equipos crearEquipo(Equipos equipos);	//CREATE
	
	public Equipos leerEquipo(String numserie); // READ
		
	public Equipos actualizarEquipo(Equipos equipo); // UPDATE
	
	public void borrarEquipo(String numserie);// DELETE
	
	
}