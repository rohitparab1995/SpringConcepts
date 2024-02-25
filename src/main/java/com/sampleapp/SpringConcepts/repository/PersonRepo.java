package com.sampleapp.SpringConcepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleapp.SpringConcepts.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{

}
