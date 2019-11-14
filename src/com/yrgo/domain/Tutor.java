package com.yrgo.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue(value="T")
public class Tutor extends Person{
	

	
//	@Column(unique = true, nullable = false)
	private String tutorId;
	private int salary;
	
	
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.PERSIST)
	private Set<Student>students;
	
	@ManyToMany
	private Set<Subject>subjects;
	
//	@OneToMany
//	@JoinColumn(name="TUTOR_FK")
//	private Set<Student>students=new HashSet<>();
	
//	@OneToMany
//	@MapKey(name="enrollmentID")
//	@JoinColumn(name="TUTOR_FK")
//	private Map<String, Student> students = new HashMap<>();
	
	
	public Tutor(String tutorId, String name, int salary) {
		super(name);
		instantiateSets();
		System.out.println("The set is " + this.students == null);
		this.tutorId = tutorId;
		this.salary = salary;
	}


	private void instantiateSets() {
		students = new HashSet<Student>();
		subjects = new HashSet<Subject>();
		
	}


	public Tutor() {
		
		super(null);
		instantiateSets();
	}


	@Override
	public String toString() {
		return "Tutor [id=" + ", tutorId=" + tutorId + ", name=" + this.getName() + ", salary=" + salary + "]";
	}



	public String getTutorId() {
		return tutorId;
	}


	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}


	public String getName() {
		return super.getName();
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Set<Student> getStudents() {
		Set<Student> unmodifiableSet = Collections.unmodifiableSet(this.students);
		return unmodifiableSet;
	}


	public void addStudentToGroup(Student student) {
		student.setTutor(this);
		this.students.add(student);
	}


	public Set<Subject> getSubjects() {
		Set<Subject> unmodifiableSet = Collections.unmodifiableSet(this.subjects);
		return unmodifiableSet;
	}


	public void addSubject(Subject subjects) {
		this.subjects.add(subjects);
	}
	
	public void createStudentAndAddToTechingGroup(String studentName, String enrollmentId, String street, String city, String zipCode ) {
		
		Student student = new Student(studentName, enrollmentId, street, city, zipCode);
		student.setTutor(this);
		this.addStudentToGroup(student);

	}


	@Override
	public void getReport() {
		System.out.println("Report for tutor: " + this.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
