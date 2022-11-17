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

import com.example.T26.dto.Facultades;
import com.example.T26.service.FacultadesServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorFacultades {
	
	@Autowired
	FacultadesServiceImpl facultadesServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultades> listarFacultades(){
		return facultadesServiceImpl.listarFacultades();
	}
	
	@PostMapping("/facultades")
	public Facultades crearFacultad(@RequestBody Facultades facultad) {
		
		return facultadesServiceImpl.crearFacultad(facultad);
		
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultades leerFacultad(@PathVariable(name="codigo") Long codigo) {
		
		Facultades facultad= new Facultades();
		
		facultad=facultadesServiceImpl.leerFacultad(codigo);
		
		System.out.println("Facultad segun ID: "+facultad);
		
		return facultad;
	}
	
	@PutMapping("/facultades/{codigo}")
	public Facultades actualizarFacultad(@PathVariable(name="codigo")Long codigo,@RequestBody Facultades facultad) {
		
		Facultades facultad_seleccionado= new Facultades();
		Facultades facultad_actualizado= new Facultades();
		
		facultad_seleccionado= facultadesServiceImpl.leerFacultad(codigo);

		facultad_seleccionado.setNombre(facultad.getNombre());

		facultad_actualizado = facultadesServiceImpl.actualizarFacultad(facultad_seleccionado);
		
		System.out.println("La facultad actualizada es: "+ facultad_actualizado);
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public void borrarFacultad(@PathVariable(name="codigo")Long codigo) {
		facultadesServiceImpl.borrarFacultad(codigo);
	}
	
	
}
