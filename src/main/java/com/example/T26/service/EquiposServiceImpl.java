package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IEquiposDAO;
import com.example.T26.dto.Equipos;

@Service
public class EquiposServiceImpl implements EquiposService{
	
	//Utilizamos los metodos de la interface IEquipoDAO, es como si instanciaramos.
	@Autowired
	IEquiposDAO iEquipoDAO;
	
	@Override
	public List<Equipos> listarEquipos() {
		return iEquipoDAO.findAll();
	}
	
	@Override
	public Equipos leerEquipo(String numserie) {
		return iEquipoDAO.findById(numserie).get();
	}
	
	@Override
	public Equipos crearEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}


	@Override
	public Equipos actualizarEquipo(Equipos equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void borrarEquipo(String numserie) {
		iEquipoDAO.deleteById(numserie);
	}

		



}