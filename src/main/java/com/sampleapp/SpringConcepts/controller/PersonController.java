package com.sampleapp.SpringConcepts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampleapp.SpringConcepts.entity.Person;
import com.sampleapp.SpringConcepts.exception.UserNotFound;
import com.sampleapp.SpringConcepts.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/person")
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Object> getPersonById(@PathVariable Integer id) {
		Optional<Person> result =  personService.getPersonById(id);
		if(result.isEmpty()) throw new UserNotFound("testtt");
		else {
			ResponseEntity<Object> obj = new ResponseEntity<Object>(result, HttpStatus.OK);
			return obj;
		}
		
	}
	
	@PostMapping("/person")
	public ResponseEntity<String> createPerson(@RequestBody Person obj){
		Integer newPerson = personService.createPerson(obj);
		
		return new ResponseEntity<String>("Created : " + newPerson, HttpStatus.OK);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Integer id) {
		String deletedPerson = personService.deletePerson(id);
		
		return new ResponseEntity<String>("Status : " + deletedPerson, HttpStatus.OK);
	}	

}
