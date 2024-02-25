package com.sampleapp.SpringConcepts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleapp.SpringConcepts.entity.Person;
import com.sampleapp.SpringConcepts.exception.UserNotFound;
import com.sampleapp.SpringConcepts.repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo personRepo;

	public List<Person> getPersons() {
		return personRepo.findAll();
	}

	public Optional<Person> getPersonById(Integer id) {
		return personRepo.findById(id);
	}

	public Integer createPerson(Person obj) {
		Person newObj = personRepo.save(obj);
		
		return newObj.getId();
		
	}

	public String deletePerson(Integer id) {
		personRepo.deleteById(id);
		
		if(personRepo.findById(id).isEmpty()) return "Deleted";
		else return "Not Deleted";
		
	}

}
