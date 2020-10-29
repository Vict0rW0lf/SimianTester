package com.ml.simiantester.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

	@JsonProperty("count_mutant_dna")
	private Long mutantDna;
	
	@JsonProperty("count_human_dna")
	private Long humanDna;
	
	private Float ratio;
	
	public Long getMutantDna() {
		return mutantDna;
	}
	public void setMutantDna(Long mutantDna) {
		this.mutantDna = mutantDna;
	}
	public Long getHumanDna() {
		return humanDna;
	}
	public void setHumanDna(Long humanDna) {
		this.humanDna = humanDna;
	}
	public Float getRatio() {
		return ratio;
	}
	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}
	
}
