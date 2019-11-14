package com.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="S")

public class Student extends Person
{

	@Column(unique = true, nullable = false)
    private String enrollmentID;

    
    @Embedded
    private Adress adress;
   
    
    
    @ManyToOne
    private Tutor tutor;
    
    
    @Column(name="All_courses")
    private Integer numberOfCourses;



    public Student(String enrollmentId, String name, String street, String city, String zipCode) {
    	super(name, enrollmentId);
    	this.enrollmentID = enrollmentId;
    	adress = new Adress(street, city, zipCode);

    }
    
    




	public Student(String enrollmentID, String name) {
		super(name, enrollmentID);
		System.out.println("Constructor called");

	}


	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}


	@Override
	public String toString() {
		return "Student [id=" +  ", enrollmentID=" + enrollmentID + " lives at adress " + 
	adress 
	+
				", name=" + super.getName() 
				+ "]";
	}

	public String getEnrollmentID() {
		return enrollmentID;
	}


	public String getName() {
		return super.getName();
	}

	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
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

	@Override
	public void getReport() {
		System.out.println("Report for student: " + this.getName());
		
	}
	

	

}
