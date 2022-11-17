package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Reservas;

public interface ReservasService {

	//Metodos del CRUD
	
	public List<Reservas> listarReservas(); //Listar All 
	
	public Reservas crearReserva(Reservas reservas);	//CREATE
			
	public Reservas actualizarReserva(Reservas reserva); // UPDATE
	
	public void borrarReserva(Long id);// DELETE

	public Reservas leerReserva(Long id); // READ
		
}
