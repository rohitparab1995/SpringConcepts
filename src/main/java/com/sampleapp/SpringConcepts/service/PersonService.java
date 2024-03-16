package com.sampleapp.SpringConcepts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sampleapp.SpringConcepts.entity.Person;
import com.sampleapp.SpringConcepts.exception.UserNotFound;
import com.sampleapp.SpringConcepts.repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo personRepo;

	public List<Person> getPersons(Integer pageNumber, Integer pageSize) {
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		Page<Person> pagePerson = personRepo.findAll(page);
		
		System.out.println("TOTAL Pages = " + pagePerson.getTotalPages());
		System.out.println("TOTAL Elements = " +pagePerson.getTotalElements());
		
		return pagePerson.getContent();
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
