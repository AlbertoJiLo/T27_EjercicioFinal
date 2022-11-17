package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Investigadores;

public interface IInvestigadoresService {

	//Metodos del CRUD
	
	public List<Investigadores> listarInvestigadores(); //Listar All 
	
	public Investigadores crearInvestigador(Investigadores investigador);	//CREATE
	
	public Investigadores leerInvestigador(String dni); // READ
		
	public Investigadores actualizarInvestigador(Investigadores investigador); // UPDATE
	
	public void borrarInvestigador(String dni);// DELETE
	
	
}