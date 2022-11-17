package com.example.T26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.T26.dto.Reservas;
import com.example.T26.service.ReservasServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorReservas {
	
	@Autowired
	ReservasServiceImpl reservasServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reservas> listarReservas(){
		return reservasServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reservas crearReserva(@RequestBody Reservas reserva) {
		
		return reservasServiceImpl.crearReserva(reserva);
		
	}
	
	
	@GetMapping("/reservas/{id}")
	public Reservas leerReserva(@PathVariable(name="id") Long id) {
		
		Reservas reserva= new Reservas();
		
		reserva=reservasServiceImpl.leerReserva(id);
		
		System.out.println("Reserva segun ID: "+reserva);
		
		return reserva;
	}
	
	@PutMapping("/reservas/{id}")
	public Reservas actualizarReserva(@PathVariable(name="id")Long id,@RequestBody Reservas reserva) {
		
		Reservas reserva_seleccionado= new Reservas();
		Reservas reserva_actualizado= new Reservas();
		
		reserva_seleccionado= reservasServiceImpl.leerReserva(id);

		reserva_seleccionado.setInvestigadores(reserva.getInvestigadores());
		reserva_seleccionado.setEquipos(reserva.getEquipos());
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());

		
		reserva_actualizado = reservasServiceImpl.actualizarReserva(reserva_seleccionado);
		
		System.out.println("El reserva actualizado es: "+ reserva_actualizado);
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void borrarReserva(@PathVariable(name="id")Long id) {
		reservasServiceImpl.borrarReserva(id);
	}
	
	
}
