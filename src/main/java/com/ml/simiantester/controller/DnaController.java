package com.ml.simiantester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.simiantester.entity.Dna;
import com.ml.simiantester.service.DnaService;

@RestController
@RequestMapping("dna")
public class DnaController {

	@Autowired
	private DnaService dnaService;
	
	@GetMapping
	public List<Dna> findAll() {
		return dnaService.findAll();
	}
	
}
