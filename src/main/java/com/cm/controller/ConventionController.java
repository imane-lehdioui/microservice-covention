package com.cm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cm.entity.Convention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.ConventionRepository;

@RestController
public class ConventionController {

	@Autowired
	private ConventionRepository conventionRepository;
	
	static long idConvention;
	static long idSub;

	@GetMapping(value = "/convention/index")
	public List<Convention> getAllConvention(@RequestParam(required = false) String title) {
		return conventionRepository.findAll();

	}

	@GetMapping(value = "/convention/show/{id}")
	public Convention getConventionById(@PathVariable(value = "id") Long convId) {
		return conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
	}


	@PostMapping(value = "/convention/new")
	public long createConvention(@Valid @RequestBody Convention sv) {
		Convention sub = new Convention();

		sub.setId(sv.getId());
		sub.setNumSubvention(sv.getNumSubvention());
		sub.setNomAssociation(sv.getNomAssociation());
		sub.setAnneeSingConvention(sv.getAnneeSingConvention());
		sub.setAnneeAcquisition(sv.getAnneeAcquisition());
		sub.setObjetConvention(sv.getObjetConvention());

		sub.setChampActivite(sv.getChampActivite());
		sub.setNatureActivite(sv.getNatureActivite());
		sub.setActivite_de_rayonnement(sv.getActivite_de_rayonnement());
		sub.setCible(sv.getCible());
		sub.setLocal(sv.getLocal());
		sub.setDuree(sv.getDuree());
		sub.setNombreRenouvelle(sv.getNombreRenouvelle());
		sub.setNatureSubvention(sv.getNatureSubvention());
		sub.setMontantDemande(sv.getMontantDemande());
		sub.setSuiveeExec(sv.getSuiveeExec());

		sub = conventionRepository.save(sub);
		idSub = sub.getId();
		return idSub;
	}

//	@PutMapping(value = "/convention/edit/{id}")
//	public Convention updateConvention(@PathVariable(value = "id") Long convId,
//			@Valid @RequestBody Convention details) {
//		Convention conv = conventionRepository.findById(convId)
//				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
//		//MAJ 08.08.20
//		conv.setDuree(details.getDuree());
//		// Oldest
//		conv.setDateEffet(details.getDateEffet());
//		conv.setDateFin(details.getDateFin());
//		conv.setDateSignature(details.getDateSignature());
//		conv.setIdAssociation(details.getIdAssociation());
//		conv.setObjet(details.getObjet());
//		//conv.setStatutConvention(details.getStatutConvention());
//		conv.setTypeConvention(details.getTypeConvention());
//		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//		conv.setUpdateDate(sqlDate);
//		return conventionRepository.save(conv);
//	}

	@DeleteMapping(value = "/convention/delete/{id}")
	public ResponseEntity<?> deleteConvention(@PathVariable(value = "id") Long convId) {
		Convention conv = conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
		conventionRepository.delete(conv);
		return ResponseEntity.ok().build();
	}


}
