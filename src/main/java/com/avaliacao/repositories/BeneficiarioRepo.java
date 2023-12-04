package com.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.models.Beneficiario;

public interface BeneficiarioRepo extends JpaRepository<Beneficiario, Integer>  {

}
