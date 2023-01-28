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

import com.cm.entity.TypeConvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.TypeConventionRepository;

@RestController
public class TypeConventionController {

	@Autowired
	private TypeConventionRepository typeConventionRepository;
	
	@GetMapping(value = "/typeConvention/index")
	public List<TypeConvention> getAllTypeConvention() {
		return typeConventionRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/typeConvention/show/{id}")
	public TypeConvention getTypeConventionById(@PathVariable(value = "id") Long convId) {
		return typeConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeConvention", "convId", convId));
	}

	@PostMapping(value = "/typeConvention/new")
	public TypeConvention createTypeConvention(@Valid @RequestBody TypeConvention act) {
		return typeConventionRepository.save(act);
	}

	@PutMapping(value = "/typeConvention/edit/{id}")
	public TypeConvention updateTypeConvention(@PathVariable(value = "id") Long convId,
			@Valid @RequestBody TypeConvention details) {
		TypeConvention typeConv = typeConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeConvention", "convId", convId));

		typeConv.setLibelle(details.getLibelle());
		
		return typeConventionRepository.save(typeConv);
	}

	@DeleteMapping(value = "/typeConvention/delete/{id}")
	public ResponseEntity<?> deleteTypeConvention(@PathVariable(value = "id") Long convId) {
		TypeConvention typeConv = typeConventionRepository.findById(convId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeConvention", "convId", convId));
		typeConventionRepository.delete(typeConv);
		return ResponseEntity.ok().build();
	}
}
