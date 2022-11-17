package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Facultades;

public interface IFacultadesService {

	//Metodos del CRUD
	
	public List<Facultades> listarFacultades(); //Listar All 
	
	public Facultades crearFacultad(Facultades facultades);	//CREATE
	
	public Facultades leerFacultad(Long codigo); // READ
		
	public Facultades actualizarFacultad(Facultades facultad); // UPDATE
	
	public void borrarFacultad(Long codigo);// DELETE
	
	
}