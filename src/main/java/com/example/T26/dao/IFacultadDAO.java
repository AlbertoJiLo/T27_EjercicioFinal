package com.example.T26.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Facultades;


public interface IFacultadDAO extends JpaRepository<Facultades, Long>{
	
}
