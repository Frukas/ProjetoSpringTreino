package com.avaliacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.avaliacao.models.Beneficiario;
import com.avaliacao.models.Documento;
import com.avaliacao.services.BeneficiarioService;

@Controller
public class BeneficiarioController {
	
	@Autowired
	private BeneficiarioService beniService;
	
	@GetMapping("/Benificiario")
	@ResponseBody
	public List<Beneficiario> getBenificiarios() {
		return beniService.getAllBeneficiario();
	}
	
	//It returns error if the user already exists. It checks the id for it.
	@PostMapping("/Benificiario")
	@ResponseBody
	public ResponseEntity<Beneficiario> addBenificiario(@RequestBody Beneficiario benefificario) {
		boolean isNewUser = benefificario.getId() <= 0;
		if(!isNewUser) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}	
		
		beniService.save(benefificario);
		return ResponseEntity.ok(benefificario);
	}
	
	@GetMapping("/Benificiario/Documento/{id}")
	@ResponseBody
	public List<Documento> getDocumento(@PathVariable("id") int id) {
		
		Beneficiario ben = beniService.getBeneficiarioById(id);
		return ben.getDocumentos();
	}
	
	//It returns a error if it is not informed the Beneficiario and Documento ids.
	@PutMapping("/Benificiario")
	@ResponseBody
	public ResponseEntity<Beneficiario> updateBeneficiarioAndDocumento(@RequestBody Beneficiario benefificario) {
		boolean isUpdate = benefificario.getId() > 0;
		if(!isUpdate) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			for(Documento d : benefificario.getDocumentos()) {
				boolean isDocumentUpdate = d.getId() > 0;
				if(!isDocumentUpdate) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
				}
			}
		}
		beniService.save(benefificario);

		return ResponseEntity.ok(benefificario);
	}
	
	@DeleteMapping("/Benificiario")
	@ResponseBody
	public ResponseEntity<String> removeBenificiario(@RequestBody Beneficiario benefificario) {
		
		try {
			beniService.removeBeneficiario(benefificario);
		}catch(IllegalArgumentException | OptimisticLockingFailureException o) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It was not possible to remove the user");
		}		

		return ResponseEntity.ok("User removed succefully");
	}	
}


