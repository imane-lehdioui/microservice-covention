package com.cm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.entity.Convention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.ConventionRepository;

@RestController
public class ConventionController {

	@Autowired
	private ConventionRepository conventionRepository;
	
	static long idConvention;
	
	@GetMapping(value = "/convention/index")
	public List<Convention> getAllConvention() {
		return conventionRepository.findByOrderByIdDesc();
	}
	
	@GetMapping(value = "/convention/index/{id}")
	public List<Convention>  getAllConventionById(@PathVariable(value = "id") Long convId) {
		return conventionRepository.findByIdAssociationOrderByIdDesc(convId);
	}
	@GetMapping(value = "/convention/show/{id}")
	public Convention getConventionById(@PathVariable(value = "id") Long convId) {
		return conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
	}
	@GetMapping(value = "/convention/count/{id}")
	public long countConventionByassosation(@PathVariable(value = "id") long convId) {
		return conventionRepository.countConventionByassosation(convId);
	}

	@PostMapping(value = "/convention/new")
	public long createConvention(@Valid @RequestBody Convention conv) {
		Convention convention = conventionRepository.save(conv);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		convention.setCreationDate(sqlDate);
		conventionRepository.save(convention);
		idConvention = convention.getId();
		return idConvention;
	}

	@PutMapping(value = "/convention/edit/{id}")
	public Convention updateConvention(@PathVariable(value = "id") Long convId,
			@Valid @RequestBody Convention details) {
		Convention conv = conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
		//MAJ 08.08.20
		conv.setDuree(details.getDuree());
		// Oldest
		conv.setDateEffet(details.getDateEffet());
		conv.setDateFin(details.getDateFin());
		conv.setDateSignature(details.getDateSignature());
		conv.setIdAssociation(details.getIdAssociation());
		conv.setObjet(details.getObjet());
		//conv.setStatutConvention(details.getStatutConvention());
		conv.setTypeConvention(details.getTypeConvention());
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		conv.setUpdateDate(sqlDate);
		return conventionRepository.save(conv);
	}

	@DeleteMapping(value = "/convention/delete/{id}")
	public ResponseEntity<?> deleteConvention(@PathVariable(value = "id") Long convId) {
		Convention conv = conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
		conventionRepository.delete(conv);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/byIdAssociation/{id}")
	public void deleteByIdAssociation(@PathVariable String id) {
		conventionRepository.deleteByIdAssociation(id);
			
	}
}
