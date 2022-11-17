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

import com.example.T26.dto.Investigadores;
import com.example.T26.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorInvestigadores {
	
	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return investigadoresServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigadores crearInvestigador(@RequestBody Investigadores investigador) {
		
		return investigadoresServiceImpl.crearInvestigador(investigador);
		
	}
	
	
	@GetMapping("/investigadores/{dni}")
	public Investigadores leerInvestigador(@PathVariable(name="dni") String dni) {
		
		Investigadores investigador= new Investigadores();
		
		investigador=investigadoresServiceImpl.leerInvestigador(dni);
		
		System.out.println("Investigador segun ID: "+investigador);
		
		return investigador;
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigadores actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigadores investigador) {
		
		Investigadores investigador_seleccionado= new Investigadores();
		Investigadores investigador_actualizado= new Investigadores();
		
		investigador_seleccionado= investigadoresServiceImpl.leerInvestigador(dni);

		investigador_seleccionado.setNomapels(investigador.getNomapels());
		investigador_seleccionado.setFacultades(investigador.getFacultades());
		
		investigador_actualizado = investigadoresServiceImpl.actualizarInvestigador(investigador_seleccionado);
		
		System.out.println("La investigador actualizada es: "+ investigador_actualizado);
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public void borrarInvestigador(@PathVariable(name="dni") String dni) {
		investigadoresServiceImpl.borrarInvestigador(dni);
	}
	
	
}
