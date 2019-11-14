package com.yrgo.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="person_type")
public abstract class Person {
	
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public abstract void getReport();
	
	public String getName() {
		return this.name;
	}
	
	

}
