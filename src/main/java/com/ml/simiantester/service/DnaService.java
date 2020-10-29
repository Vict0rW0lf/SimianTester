package com.ml.simiantester.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.simiantester.entity.Dna;
import com.ml.simiantester.enums.Type;
import com.ml.simiantester.repository.DnaRepository;

@Service
public class DnaService {
	
	@Autowired
	private DnaRepository dnaRepo;

	public void save(Dna dna) {
		dnaRepo.save(dna);
	}
	
	public List<Dna> findAll() {
		return StreamSupport
		  .stream(dnaRepo.findAll().spliterator(), false)
		  .collect(Collectors.toList());
	}
	
	public Long countByType(Type type) {
		return dnaRepo.countByType(type);
	}
	
}
