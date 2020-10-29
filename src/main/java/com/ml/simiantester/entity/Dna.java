package com.ml.simiantester.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ml.simiantester.enums.Type;

@Entity
@Table(name="TB_DNA")
public class Dna {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DNA_ID")
	private Long id;
	
	@Column(name="DNA_SEQUENCE", unique=true)
	private String dnaSequence;
	
	@Column(name = "DNA_TYPE")
	private Type type;
	
	@Column(name="DNA_DATE_CREATION")
    private LocalDateTime dateCreated;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDnaSequence() {
		return dnaSequence;
	}
	public void setDnaSequence(String dnaSequence) {
		this.dnaSequence = dnaSequence;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
