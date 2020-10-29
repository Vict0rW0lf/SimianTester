package com.ml.simiantester.service;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.simiantester.entity.Dna;
import com.ml.simiantester.enums.Type;

@Service
public class TesterService {

	@Autowired
	private DnaService dnaService;
	
	public boolean isSimian(String[] dna) {
		boolean isSimian = checkHorizontally(dna) || checkVertically(dna) || checkDiagonally(dna);
		
		Dna currentDna = new Dna();
		currentDna.setDateCreated(LocalDateTime.now());
		
		if (isSimian) 
			currentDna.setType(Type.SIMIAN);
		else 
			currentDna.setType(Type.HUMAN);
		
		currentDna.setDnaSequence(turnListIntoDnaSequence(dna));
		
		dnaService.save(currentDna);
		
		return isSimian;
	}

	public boolean checkHorizontally(String[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int counter = 0;
			int tempCounter = 0;

			for (int j = 0; j < (6 - 1); j++) {

				if (arr[i].charAt(j) == arr[i].charAt(j + 1)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

			}

			if (counter == 3 || tempCounter == 3)
				return true;
		}

		return false;
	}

	public boolean checkVertically(String[] arr) {
		
		for (int i = 0; i < 6; i++) {
			int counter = 0;
			int tempCounter = 0;

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j].charAt(i) == arr[j + 1].charAt(i)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

			}

			if (counter == 3 || tempCounter == 3)
				return true;
		}

		return false;
	}

	public boolean checkDiagonally(String[] arr) {
		return firstStep(arr) || secondStep(arr) || thirdStep(arr) || fourthStep(arr);
	}

	private boolean fourthStep(String[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int temp = 0;
			int j = i;

			if ((arr.length - j) < 4)
				break;

			int counter = 0;
			int tempCounter = 0;

			while (temp < 5 && j < arr.length - 1) {

				if (arr[j].charAt(temp) == arr[j + 1].charAt(temp + 1)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

				temp++;
				j++;
			}

			if (counter == 3 || tempCounter == 3)
				return true;
		}

		return false;
	}

	private boolean thirdStep(String[] arr) {
		
		for (int i = arr.length - 4; i >= 0; i--) {

			int temp = i;
			int j = 0;
			int counter = 0;
			int tempCounter = 0;

			while (temp <= (arr.length - 1) - 1) {

				if (arr[j].charAt(temp) == arr[j + 1].charAt(temp + 1)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

				temp++;
				j++;
			}

			if (counter == 3 || tempCounter == 3)
				return true;
		}
		
		return false;
	}

	private boolean secondStep(String[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int temp = 5;
			int j = i;

			if ((arr.length - j) < 4)
				break;

			int counter = 0;
			int tempCounter = 0;

			while (temp > 0 && j < arr.length - 1) {
				if (arr[j].charAt(temp) == arr[j + 1].charAt(temp - 1)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

				temp--;
				j++;
			}

			if (counter == 3 || tempCounter == 3)
				return true;
		}
		
		return false;
	}

	private boolean firstStep(String[] arr) {
		
		for (int i = 3; i < arr.length; i++) {
			int temp = i;
			int j = 0;

			int counter = 0;
			int tempCounter = 0;

			while (temp > 0) {

				if (arr[j].charAt(temp) == arr[j + 1].charAt(temp - 1)) {
					tempCounter++;
				} else {

					if (tempCounter > counter)
						counter = tempCounter;

					tempCounter = 0;
				}

				temp--;
				j++;
			}
			if (counter == 3 || tempCounter == 3)
				return true;
		}
		
		return false;
	}
	
	public String turnListIntoDnaSequence(String[] dna) {
		
		String sequence = "";
		
		for (int i = 0; i < dna.length; i++) {
			sequence += dna[i];
		}
		
		return sequence;
	}

	public boolean isInvalidDna(String[] dna) {
		
		HashMap<Character, Integer> validCharacters = new HashMap<Character, Integer>() {
			{
				put('A', 1);
				put('T', 1);
				put('C', 1);
				put('G', 1);
			}
		};
		
		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < 6; j++) {
				if (validCharacters.containsKey(dna[i].charAt(j)) == false) 
					return true;
			}
		}
		
		return false;
	}

}
