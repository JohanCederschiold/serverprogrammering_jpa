package com.yrgo.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yrgo.domain.Tutor;

public class TutorService {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
	private EntityManager em = emf.createEntityManager();
	
	public Tutor createNewTutor(String staffId, String name, int salary) {
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Tutor newTutor = new Tutor(staffId, name, salary);
		em.persist(newTutor);
		tx.commit();
		em.close();
		return newTutor;
	}
	
	public Tutor updateTutor(Tutor tutorToUpdate) {
		
		em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		tutorToUpdate = em.merge(tutorToUpdate);
		
		tx.commit();
		em.close();
		return tutorToUpdate;
	}

}
