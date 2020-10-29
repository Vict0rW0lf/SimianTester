package com.ml.simiantester.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.simiantester.dto.Stats;
import com.ml.simiantester.enums.Type;

@Service
public class StatisticsService {

	@Autowired
	private DnaService dnaService;
	
	public Stats showStats() {
		
		Long simeans = dnaService.countByType(Type.SIMIAN);
		Long humans = dnaService.countByType(Type.HUMAN);
		
		Stats stats = new Stats();
		stats.setMutantDna(simeans);
		stats.setHumanDna(humans);
		stats.setRatio(calculateRatio(simeans, humans));
		
		return stats;
	}
	
	public Float calculateRatio(Long simeans, Long humans) {
		
		float s = simeans;
		float h = humans;
		
		if (s == 0 && h == 0) {
			return 0f;
		} else if (s == 0) {
			return 0f;
		} else if(h == 0) {
			return s;
		}
		
		return s / h;
	}
	
}
