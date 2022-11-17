package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IInvestigadoresDAO;
import com.example.T26.dto.Investigadores;

@Service
public class InvestigadoresServiceImpl implements IInvestigadoresService{
	
	//Utilizamos los metodos de la interface IInvestigadorDAO, es como si instanciaramos.
	@Autowired
	IInvestigadoresDAO iInvestigadorDAO;
	
	@Override
	public List<Investigadores> listarInvestigadores() {
		return iInvestigadorDAO.findAll();
	}
	
	@Override
	public Investigadores crearInvestigador(Investigadores dni) {
		return iInvestigadorDAO.save(dni);
	}

	@Override
	public Investigadores leerInvestigador(String dni) {
		return iInvestigadorDAO.findById(dni).get();
	}


	@Override
	public Investigadores actualizarInvestigador(Investigadores investigador) {
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public void borrarInvestigador(String dni) {
		iInvestigadorDAO.deleteById(dni);
	}

}