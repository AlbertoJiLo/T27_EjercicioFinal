package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IFacultadDAO;
import com.example.T26.dto.Facultades;

@Service
public class FacultadesServiceImpl implements IFacultadesService{
	
	//Utilizamos los metodos de la interface IFacultadDAO, es como si instanciaramos.
	@Autowired
	IFacultadDAO iFacultadDAO;
	
	@Override
	public List<Facultades> listarFacultades() {
		return iFacultadDAO.findAll();
	}
	
	@Override
	public Facultades crearFacultad(Facultades facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultades leerFacultad(Long codigo) {
		return iFacultadDAO.findById(codigo).get();
	}


	@Override
	public Facultades actualizarFacultad(Facultades facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void borrarFacultad(Long codigo) {
		iFacultadDAO.deleteById(codigo);
	}


}
