package com.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tbl_Student")
public class Student
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String enrollmentID;
    private String name;
    
    @Embedded
    private Adress adress;
    
    @ManyToOne
    private Tutor tutor;
    
    
    @Column(name="All_courses")
    private Integer numberOfCourses;


//    public Student(String name, Tutor tutor)
//    {
//    	this.name = name;
//    	this.tutor = tutor;
//    }

    public Student(String enrollmentId, String name, String street, String city, String zipCode) {
    	this.enrollmentID = enrollmentId;
    	this.name = name;
    	adress = new Adress(street, city, zipCode);
    }

    public Student(String enrollmentID, String name) {
		super();
		System.out.println("Constructor called");
		this.enrollmentID = enrollmentID;
		this.name = name;
		System.out.println(this.enrollmentID);
		System.out.println(this.name);
	}


	public Student() {
		super();
	}


	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollmentID=" + enrollmentID + " lives at adress " + adress +
				", name=" + name 
				+ "]";
	}



	public Student(String name)
    {
    	this.name = name;
    	this.numberOfCourses = 10;
    }




	public Long getId() {
		return id;
	}


	public String getEnrollmentID() {
		return enrollmentID;
	}


	public String getName() {
		return name;
	}

	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enrollmentID == null) ? 0 : enrollmentID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (enrollmentID == null) {
			if (other.enrollmentID != null)
				return false;
		} else if (!enrollmentID.equals(other.enrollmentID))
			return false;
		return true;
	}






	public Tutor getTutor() {
		return tutor;
	}






	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	


	


//	public void alocateTutor(Tutor tutor) {
//		this.tutor = tutor;
//	}
	
//	public String getTutorName() {
//		return this.tutor.getName();
//	}
	
	
	

}
