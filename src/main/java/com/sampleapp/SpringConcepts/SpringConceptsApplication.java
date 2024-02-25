package com.sampleapp.SpringConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.sampleapp.SpringConcepts.exception.CustomizedExceptions;

@SpringBootApplication
@Import(CustomizedExceptions.class)
public class SpringConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConceptsApplication.class, args);
	}

}
 