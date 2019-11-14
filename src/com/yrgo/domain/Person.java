package com.yrgo.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="person_type")
public abstract class Person {
	
	private String name;
	
	@Id
	private String id;
	

	
	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public abstract void getReport();
	
	public String getName() {
		return this.name;
	}
	
	

}
