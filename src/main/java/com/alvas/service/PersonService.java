package com.alvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alvas.dao.PersonDao;
import com.alvas.dto.Person;

@Component
public class PersonService {
	@Autowired
	PersonDao pDao;
	@RequestMapping(value="/register")
	public Person saveperson(Person p){
		
		
		return pDao.saveperson(p);
	}
	public List<Person> getAllPersons() {
		
		return pDao.getAllPersons();
	}

	public boolean delete(int id) {
		
		return pDao.delete(id);
	}
	public Person getPersonById(int id) {
	
		return pDao.getPersonById(id);
	}
	public Person updatePerson(Person p, int id) {
		
		return pDao.updatePerson(p,id);
	}
}
