package com.yrgo.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yrgo.domain.Student;
import com.yrgo.domain.Subject;
import com.yrgo.domain.Tutor;

public class JPATest {

	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Tutor t1 = new Tutor("ABC123", "Teacher 1", 290000);

		em.persist(t1);
		Student s1 = new Student("Student1", "1-STU-2019");
		t1.addStudentToGroup(s1);
		Student s2 = new Student("Student2", "2-STU-2018");
		t1.addStudentToGroup(s2);
		Student s3 = new Student("Student3", "3-STU-2017");
		t1.addStudentToGroup(s3);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		Set<Student> allStudents = t1.getStudents();
		System.out.println(allStudents.size());

		tx.commit();
		em.close();

	}

}
