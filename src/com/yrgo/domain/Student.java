package com.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
    
    
    @Column(name="All_courses")
    private Integer numberOfCourses;


    public Student(String name, Tutor tutor)
    {
    	this.name = name;
    }
    
    
    
    


    public Student(String enrollmentID, String name) {
		super();
		this.enrollmentID = enrollmentID;
		this.name = name;
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
		return "Student [id=" + id + ", enrollmentID=" + enrollmentID + 
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




//	public void alocateTutor(Tutor tutor) {
//		this.tutor = tutor;
//	}
	
//	public String getTutorName() {
//		return this.tutor.getName();
//	}
	
	
	

}
