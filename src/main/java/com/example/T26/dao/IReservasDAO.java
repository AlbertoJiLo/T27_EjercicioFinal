package com.example.T26.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Reservas;


public interface IReservasDAO extends JpaRepository<Reservas, Long>{
	
}
