package com.avaliacao.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.models.Beneficiario;
import com.avaliacao.models.Documento;
import com.avaliacao.repositories.BeneficiarioRepo;
import com.avaliacao.repositories.DocumentoRepo;

@Service
public class BeneficiarioService {

	@Autowired
	BeneficiarioRepo repo;
	
	@Autowired
	DocumentoRepo docRepo;
	
	public void save(Beneficiario beneficiario) {
		
		insertDataAtualizacaoInclusao(beneficiario);
		repo.save(beneficiario);
	}
	
	
	public List<Beneficiario> getAllBeneficiario(){
		
		return repo.findAll();		
	}
	
	public Beneficiario getBeneficiarioById(int id) {
		
		return repo.getReferenceById(id);
	}
	
	public void removeBeneficiario(Beneficiario beneficiario) {
		
		Beneficiario b = repo.getReferenceById(beneficiario.getId());
		for(Documento d : b.getDocumentos()) {
			docRepo.delete(d);
		}
		repo.delete(beneficiario);
	}
	
	private void insertDataAtualizacaoInclusao(Beneficiario beneficiario) {
		
		Beneficiario b = null;	
		LocalDateTime inclusaoTime;
		boolean isUpdate = beneficiario.getId() > 0;
		
		if(isUpdate) {
			 b =   getBeneficiarioById(beneficiario.getId());
			 inclusaoTime = b.getDataInclusao();
		}else {
			inclusaoTime = LocalDateTime.now();	
		}
		
		beneficiario.setDataInclusao(inclusaoTime);
		beneficiario.setDataAtualizacao(LocalDateTime.now());
		
		for( Documento d : beneficiario.getDocumentos()) {			

			d.setDataInclusao(inclusaoTime);	
			d.setDataAtualizacao(LocalDateTime.now());

		}
	}	
}
