package com.ml.simiantester.repository;

import org.springframework.data.repository.CrudRepository;

import com.ml.simiantester.entity.Dna;
import com.ml.simiantester.enums.Type;

public interface DnaRepository extends CrudRepository<Dna, Long>{

	Long countByType(Type type);
	
}
