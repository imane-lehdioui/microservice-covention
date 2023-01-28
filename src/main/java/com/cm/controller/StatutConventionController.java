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

import com.cm.entity.StatutConvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.StatutConventionRepository;

@RestController
public class StatutConventionController {


	@Autowired
	private StatutConventionRepository statutConventionRepository;
	
	@GetMapping(value = "/statutConvention/index")
	public List<StatutConvention> getAllStatutConvention() {
		return statutConventionRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/statutConvention/show/{id}")
	public StatutConvention getStatutConventionById(@PathVariable(value = "id") Long convId) {
		return statutConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("StatutConvention", "convId", convId));
	}

	@PostMapping(value = "/statutConvention/new")
	public StatutConvention createStatutConvention(@Valid @RequestBody StatutConvention act) {
		return statutConventionRepository.save(act);
	}

	@PutMapping(value = "/statutConvention/edit/{id}")
	public StatutConvention updateStatutConvention(@PathVariable(value = "id") Long convId,
			@Valid @RequestBody StatutConvention details) {
		StatutConvention statConv = statutConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("StatutConvention", "convId", convId));

		statConv.setLibelle(details.getLibelle());
		
		return statutConventionRepository.save(statConv);
	}

	@DeleteMapping(value = "/statutConvention/delete/{id}")
	public ResponseEntity<?> deleteStatutConvention(@PathVariable(value = "id") Long convId) {
		StatutConvention statConv = statutConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("StatutConvention", "convId", convId));
		statutConventionRepository.delete(statConv);
		return ResponseEntity.ok().build();
	}
	
}
