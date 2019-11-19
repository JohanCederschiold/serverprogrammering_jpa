package com.yrgo.test;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.yrgo.domain.Student;
import com.yrgo.domain.Subject;
import com.yrgo.domain.Tutor;
import com.yrgo.services.TutorService;

public class HibernateTest 
{
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");

	public static void main(String[] args)
	{

		TutorService service = new TutorService();
		Tutor coolTutor = service.createNewTutor("bob105", "Bob", 900998);
		coolTutor.addStudentToGroup(new Student("lala123", "Hamsterdance"));
		coolTutor.addStudentToGroup(new Student("lala124", "Lobsterdance"));
		service.updateTutor(coolTutor);
		
		
	}


	private static void reportQueryForSemestersPerSubject(EntityManager em) {
		
		double average = (double) em.createQuery("select avg(subject.numberOfSemesters) from Subject "
				+ "as subject").getSingleResult();
		
		System.out.println(average);
	}


	private static void reportQueryOfStudentsAndTutors(EntityManager em) {
		List<Object[]> studentsAndTutors = em.createQuery("select student.name, student.tutor from "
				+ "Student as student").getResultList();
		
		for (Object[] objects : studentsAndTutors) {
			System.out.println(objects[0] + " is tutored by " + objects[1]);
		}
	}


	private static void reportQueryOfStudentsNames(EntityManager em) {
		List<String> studentNames = em.createQuery("select student.name from Student as student").getResultList();
		for (String string : studentNames) {
			System.out.println(string);
		}
	}


	private static void useNamedQueryForStudentName(EntityManager em, String name) {
		List<Student> students = em.createNamedQuery("searchByName")
				.setParameter("name", name)
				.getResultList();
		
		for (Student student : students ) {
			System.out.println(student);
		}
	}
	
	
	private static void useJoins(EntityManager em, String city) {
		
		@SuppressWarnings("unchecked")
		List<Tutor> results = em.createQuery("select distinct tutor from Tutor as tutor join tutor.students as "
				+ "student where student.adress.city = :city")
				.setParameter("city", city)
				.getResultList();
		
		for (Tutor tutor : results ) {
			System.out.println(tutor);
		}
	}
	
	
	private static void printStudentsWithTutorsTeachingSubject(EntityManager em, Long SubjectId) {
		
		Subject subject = em.find(Subject.class, SubjectId);
		
		List<Student> students = em.createQuery("from Student as student where :subject member of "
				+ "student.tutor.subjects", Student.class)
				.setParameter("subject", subject)
				.getResultList();
		
		for (Student student : students) {
			System.out.println(student);
		}
		
		
	}
	
	
	private static void printTutorsTeachingSubject (EntityManager em, Long id) {
		
		Subject subject = em.find(Subject.class, id);
		
		List<Tutor> tutors = em.createQuery("from Tutor as tutor where :subject member of tutor.subjects", Tutor.class)
				.setParameter("subject", subject)
				.getResultList();
		
		for (Tutor tutor : tutors ) {
			System.out.println(tutor);
		}
		
	}
	
	
	
	private static void printStudentsForTutor(EntityManager em, Long tutorId) {
		
		Tutor tutor = em.find(Tutor.class, tutorId);
		TypedQuery<Student> query = em.createQuery("from Student as student"
				+ " where student.tutor = :tutor", Student.class);
		query.setParameter("tutor", tutor);
	
		List<Student> students = query.getResultList();
		
		for (Student student : students) {
			System.out.println(student);
		}

	}
	
	

	private static void queryByDynamicParams(EntityManager em, String name) {
		
		TypedQuery<Student> query = em.createQuery("from Student as student where name = :name", Student.class);
		query.setParameter("name", name);
		List<Student> students = query.getResultList();
		
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void queryWithLike(EntityManager em) {
		TypedQuery<Student> query = em.createQuery("from Student as student where "
				+ "student.name like 'Jim%'", Student.class);

		List<Student> students = query.getResultList();
		System.out.println(students.size());
		for (Student student : students ) {
			System.out.println(student);
		}
	}

	private static void queryStudentByName(EntityManager em) {
		TypedQuery<Student> query = em.createQuery("from Student as student where student.name = 'Jimi Hendriks'", Student.class);
		List<Student> students = query.getResultList();
		for (Student student: students) {
			System.out.println(students);
		}
	}

	private static void queryAllStudents(EntityManager em) {
		Query query = em.createQuery("from Student"); 
		List<Student> students = query.getResultList();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void queryPersistedData(EntityManager em) {
		Student student = em.find(Student.class, 2L);
		System.out.println(student);
		Tutor tutor = student.getTutor();
		System.out.println(tutor);
		
		Set<Subject> subjects =  tutor.getSubjects();
		for (Subject subject: subjects) {
		System.out.println(subject);
		}
	}

	public static void setUpData()
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();


		Subject mathematics = new Subject("Mathematics", 2);
		Subject science = new Subject("Science", 2);
		Subject programming = new Subject("Programming", 3);
		em.persist(mathematics);
		em.persist(science);
		em.persist(programming);

		Tutor t1 = new Tutor("ABC123", "Johan Smith", 40000);
		t1.addSubject(mathematics);
		t1.addSubject(science);


		Tutor t2 = new Tutor("DEF456", "Sara Svensson", 20000);
		t2.addSubject(mathematics);
		t2.addSubject(science);

		// This tutor is the only tutor who can teach History
		Tutor t3 = new Tutor("GHI678", "Karin Lindberg", 0);
		t3.addSubject(programming);

		em.persist(t1);
		em.persist(t2);
		em.persist(t3);


		t1.createStudentAndAddToTechingGroup("1-HEN-2019", "Jimi Hendriks", "Street 1", "city 2", "1212");
		t1.createStudentAndAddToTechingGroup( "2-LEE-2019",  "Bruce Lee","Street 2", "city 2", "2323");
		t3.createStudentAndAddToTechingGroup("3-WAT-2018", "Roger Waters", "Street 3", "city 3", "34343");

		tx.commit();
		em.close();
	}


}
