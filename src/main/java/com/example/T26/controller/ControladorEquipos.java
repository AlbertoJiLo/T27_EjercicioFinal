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

import com.example.T26.dto.Equipos;
import com.example.T26.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorEquipos {
	
	@Autowired
	EquiposServiceImpl equiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return equiposServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipos crearEquipo(@RequestBody Equipos equipo) {
		
		return equiposServiceImpl.crearEquipo(equipo);
		
	}
	
	
	@GetMapping("/equipos/{numserie}")
	public Equipos leerEquipo(@PathVariable(name="numserie") String numserie) {
		
		Equipos equipo= new Equipos();
		
		equipo=equiposServiceImpl.leerEquipo(numserie);
		
		System.out.println("Equipo segun ID: "+equipo);
		
		return equipo;
	}
	
	@PutMapping("/equipos/{numserie}")
	public Equipos actualizarEquipo(@PathVariable(name="numserie")String numserie,@RequestBody Equipos equipo) {
		
		Equipos equipo_seleccionado= new Equipos();
		Equipos equipo_actualizado= new Equipos();
		
		equipo_seleccionado= equiposServiceImpl.leerEquipo(numserie);

		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultades(equipo.getFacultades());

		
		equipo_actualizado = equiposServiceImpl.actualizarEquipo(equipo_seleccionado);
		
		System.out.println("La equipo actualizada es: "+ equipo_actualizado);
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{numserie}")
	public void borrarEquipo(@PathVariable(name="numserie") String numserie) {
		equiposServiceImpl.borrarEquipo(numserie);
	}
	
	
}
