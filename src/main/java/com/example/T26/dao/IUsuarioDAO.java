package com.example.T26.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}