package com.ml.simiantester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticsServiceTest {

	@Autowired
	private StatisticsService service;
	
	@Test
	public void calculateRatio() {
		assertEquals(service.calculateRatio(0L, 0L), 0.0f);
		assertEquals(service.calculateRatio(0L, 3L), 0.0f);
		assertEquals(service.calculateRatio(5L, 0L), 5.0f);
		assertEquals(service.calculateRatio(10L, 2L), 5.0f);
		assertEquals(service.calculateRatio(2L, 10L), 0.2f);
	}
	
}
