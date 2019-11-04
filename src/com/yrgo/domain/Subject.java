package com.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Subject {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String subjectName;
	private int numberOfSemesters;
	
	@ManyToMany
	private Set<Tutor> tutorsTeaching;
	
	
	public Subject() {
		this(null, 0);
		
	}
	


	public Subject(String subjectName, int numberOfSemesters) {
		
		super();
		instantiateSet();
		this.subjectName = subjectName;
		this.numberOfSemesters = numberOfSemesters;
		
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public int getNumberOfSemesters() {
		return numberOfSemesters;
	}


	public void setNumberOfSemesters(int numberOfSemesters) {
		this.numberOfSemesters = numberOfSemesters;
	}
	
	public void instantiateSet() {
		this.tutorsTeaching = new HashSet<Tutor>();
	}
	
	
	
	
	
	

}
