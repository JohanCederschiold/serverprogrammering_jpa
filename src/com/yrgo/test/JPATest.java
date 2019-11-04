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

		tx.commit();
		em.close();

	}

}
