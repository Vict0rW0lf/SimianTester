package com.ml.simiantester.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.simiantester.dto.Stats;
import com.ml.simiantester.service.StatisticsService;

@RestController
@RequestMapping("stats")
public class StatisticsController {

	@Autowired
	private StatisticsService service;
	
	@GetMapping
	public Stats stats() {
		return service.showStats();
	}
	
}
