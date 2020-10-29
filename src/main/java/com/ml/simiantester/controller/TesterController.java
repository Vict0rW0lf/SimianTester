package com.ml.simiantester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.simiantester.dto.Dna;
import com.ml.simiantester.service.TesterService;

@RestController
@RequestMapping("tester")
public class TesterController {
	
	@Autowired
	private TesterService service;
	
	@PostMapping
	public ResponseEntity<Void> isSimean(@RequestBody Dna dna) {
		
		if (service.isInvalidDna(dna.getDna()))
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		
		if (service.isSimian(dna.getDna())) 
			return new ResponseEntity<Void>(HttpStatus.OK);
		
	    return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
	}

}
