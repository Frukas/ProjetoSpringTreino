package com.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.models.Documento;

public interface DocumentoRepo extends JpaRepository<Documento, Integer> {
	
}
