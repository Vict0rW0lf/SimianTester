package com.ml.simiantester.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TesterServiceTest {
	
	@Autowired
	private TesterService service;
	
	@Test
	public void testCheckHorizontally() {
		
		String[] dna0 = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		String[] dna1 = {"CTGAGA", "CTGAGC", "TATTGT", "AGACAG", "CTCATA", "TCAAAA"};
		
		String[] dna2 = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGCC", "CACCTA", "TCACTG"};
		String[] dna3 = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGCC", "TACCTA", "TCACTG"};
		
		assertTrue(service.checkHorizontally(dna0));
		assertTrue(service.checkHorizontally(dna1));
		assertFalse(service.checkHorizontally(dna2));
		assertFalse(service.checkHorizontally(dna3));
	}
	
	@Test
	public void testCheckVertically() {
		
		String[] dna0 = {"CTGAGA", "CTAGGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		String[] dna1 = {"CTGATA", "CTGAGC", "TAGTGT", "AGAGGG", "CCCCGA", "TCACTG"};
		
		String[] dna2 = {"CTGACA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		String[] dna3 = {"CTGAAA", "CTCAGC", "TACTGT", "AGAGAG", "CTCCTA", "TAACTG"};

		assertTrue(service.checkVertically(dna0));
		assertTrue(service.checkVertically(dna1));
		assertFalse(service.checkVertically(dna2));
		assertFalse(service.checkVertically(dna3));
	}
	
	@Test
	public void checkDiagonally() {
		
		String[] dna0 = {"CTGAGA", "CTAGGC", "TATTGT", "AGAGTC", "CTACTA", "TCACTG"};
		String[] dna1 = {"CTGAGA", "CTTGGC", "TATTGT", "AGAGTC", "CTACTA", "TCACTG"};
		String[] dna2 = {"CTGAGA", "CTATGC", "TTATGT", "AGAGTG", "CACTTA", "TCTCTG"};
		String[] dna3 = {"CTGAGA", "CTATGC", "TCCTGT", "AGCGTG", "CACCTA", "TCACTG"};
		
		String[] dna4 = {"CTGAGA", "ATATGC", "TCCTGT", "AGCGTG", "CACCTA", "TCACTG"};
		String[] dna5 = {"TCTCTG", "CACTTA", "TTATGT", "AGAGTG", "CTATGC", "CTGAGA"};
		
		assertTrue(service.checkDiagonally(dna0));
		assertTrue(service.checkDiagonally(dna1));
		assertTrue(service.checkDiagonally(dna2));
		assertTrue(service.checkDiagonally(dna3));
		assertFalse(service.checkDiagonally(dna4));
		assertFalse(service.checkDiagonally(dna5));
	}
	
	@Test
	public void testIsSimian() {
	
		String[] dna0 = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		String[] dna1 = {"CTGAGA", "CTAGGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		String[] dna2 = {"CTGATA", "CTGAGC", "TAGTGT", "AGAGGG", "CCCCGA", "TCACTG"};
		String[] dna3 = {"CTGAGA", "CTATGC", "TCCTGT", "AGCGTG", "CACCTA", "TCACTG"};
		
		String[] dna4 = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGCC", "CACCTA", "TCACTG"};
		String[] dna5 = {"TCTCTG", "CACTTA", "TTATGT", "AGAGTG", "CTATGC", "CTGAGA"};
		
		assertTrue(service.isSimian(dna0));
		assertTrue(service.isSimian(dna1));
		assertTrue(service.isSimian(dna2));
		assertTrue(service.isSimian(dna3));
		
		assertFalse(service.isSimian(dna4));
		assertFalse(service.isSimian(dna5));
	}
	
	@Test
	public void testIsInvalidDna() {
		
		String[] dna0 = {"CTGAGX", "CTAGGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		String[] dna1 = {"CTGAGA", "CTATGC", "TCCTBT", "AGCGTG", "CACCTW", "TCACTG"};
		
		String[] dna2 = {"CTGAGA", "CTAGGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		String[] dna3 = {"CTGAGA", "CTATGC", "TCCTGT", "AGCGTG", "CACCTA", "TCACTG"};
		
		
		assertTrue(service.isInvalidDna(dna0));
		assertTrue(service.isInvalidDna(dna1));
		
		assertFalse(service.isInvalidDna(dna2));
		assertFalse(service.isInvalidDna(dna3));
	}
	
	
}
