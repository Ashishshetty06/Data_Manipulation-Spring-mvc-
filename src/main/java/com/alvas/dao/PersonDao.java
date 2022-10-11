package com.alvas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alvas.dto.Person;

@Component
public class PersonDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Person saveperson(Person p) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(p);
		et.commit();
		return entityManager.find(Person.class, p.getId());
	}
	public boolean  delete(int id){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person p2=entityManager.find(Person.class, id);
		if(p2!=null){
			entityTransaction.begin();
			entityManager.remove(id);
			entityTransaction.commit();
			return true;
		}
		else{
			return false;
		}
		
	}
	public List<Person> getAllPersons() {
		EntityManager eManager=entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction=eManager.getTransaction();
		String pString="select p from Person p";
	Query query=eManager.createQuery(pString);
	
		
		return query.getResultList();
	}
	public Person getPersonById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return  entityManager.find(Person.class, id);
	}
	public Person updatePerson(Person p, int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person p2= entityManager.find(Person.class, id);
		if(p2!=null){
			entityTransaction.begin();
			entityManager.merge(p);
			entityTransaction.commit();
			return entityManager.find(Person.class, id);
			
		}else{
			return null;
		}
	}
}
