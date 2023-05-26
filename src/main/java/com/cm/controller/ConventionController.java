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
	static long idAss;

	@GetMapping(value = "/convention/index")
	public List<Convention> getAllConvention(@RequestParam(required = false) String title) {
		return conventionRepository.findAll();

	}

	@GetMapping(value = "/convention/show/{id}")
	public Convention getConventionById(@PathVariable(value = "id") Long convId) {
		return conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
	}

	@PostMapping("/convention/new")
	public long createConvention(@Valid @RequestBody Convention ass) {

		Convention assoc = conventionRepository.save(ass);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

		conventionRepository.save(assoc);
		idAss = assoc.getId();
		return idAss;
	}


//	@PostMapping(value = "/convention/new")
//	public long createConvention(@Valid @RequestBody Convention sv) {
//		Convention sub = new Convention();
//
//		sub.setId(sv.getId());
//		sub.setNumSubvention(sv.getNumSubvention());
//		sub.setNomAssociation(sv.getNomAssociation());
//		sub.setAnneeSingConvention(sv.getAnneeSingConvention());
//		sub.setAnneeAcquisition(sv.getAnneeAcquisition());
//		sub.setArrondissement(sv.getArrondissement());
//		sub.setObjetConvention(sv.getObjetConvention());
//
//		sub.setChampActivite(sv.getChampActivite());
//		sub.setNatureActivite(sv.getNatureActivite());
//		sub.setActivite_de_rayonnement(sv.getActivite_de_rayonnement());
//		sub.setCible(sv.getCible());
//		sub.setLocal(sv.getLocal());
//		sub.setDuree(sv.getDuree());
//		sub.setNombreRenouvelle(sv.getNombreRenouvelle());
//		sub.setNatureSubvention(sv.getNatureSubvention());
//		sub.setMontantDemande(sv.getMontantDemande());
//		sub.setSuiveeExec(sv.getSuiveeExec());
//
//		sub = conventionRepository.save(sub);
//		idSub = sub.getId();
//		return idSub;
//	}

	@PutMapping(value = "/convention/edit/{id}")
	public Convention updateConvention(@PathVariable(value = "id") Long convId,
			@Valid @RequestBody Convention details) {
		Convention conv = conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
		//MAJ 08.08.20
		conv.setDuree(details.getDuree());
	// Oldest
	conv.setNumSubvention(details.getNumSubvention());
		conv.setNomAssociation(details.getNomAssociation());
		conv.setArrondissement(details.getArrondissement());
	    conv.setAnneeSingConvention(details.getAnneeSingConvention());
		conv.setAnneeAcquisition(details.getAnneeAcquisition());
		conv.setObjetConvention(details.getObjetConvention());
		conv.setChampActivite(details.getChampActivite());
		conv.setNatureActivite(details.getNatureActivite());
		conv.setActivite_de_rayonnement(details.getActivite_de_rayonnement());
		conv.setCible(details.getCible());
		conv.setLocal(details.getLocal());
		conv.setDuree(details.getDuree());
		conv.setNombreRenouvelle(details.getNombreRenouvelle());
		conv.setNatureSubvention(details.getNatureSubvention());
		conv.setMontantDemande(details.getMontantDemande());
		conv.setSuiveeExec(details.getSuiveeExec());

	return conventionRepository.save(conv);
	}

	@DeleteMapping(value = "/convention/delete/{id}")
	public ResponseEntity<?> deleteConvention(@PathVariable(value = "id") Long convId) {
		Convention conv = conventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("Convention", "convId", convId));
		conventionRepository.delete(conv);
		return ResponseEntity.ok().build();
	}


}
