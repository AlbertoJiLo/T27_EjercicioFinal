package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IReservasDAO;
import com.example.T26.dto.Reservas;

@Service
public class ReservasServiceImpl implements ReservasService{
	
	//Utilizamos los metodos de la interface IReservaDAO, es como si instanciaramos.
	@Autowired
	IReservasDAO iReservaDAO;
	
	@Override
	public List<Reservas> listarReservas() {
		return iReservaDAO.findAll();
	}
	
	@Override
	public Reservas leerReserva(Long id) {
		return iReservaDAO.findById(id).get();
	}
	
	@Override
	public Reservas crearReserva(Reservas reserva) {
		return iReservaDAO.save(reserva);
	}


	@Override
	public Reservas actualizarReserva(Reservas reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public void borrarReserva(Long id) {
		iReservaDAO.deleteById(id);
	}

		



}
