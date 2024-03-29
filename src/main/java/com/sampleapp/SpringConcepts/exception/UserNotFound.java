package com.sampleapp.SpringConcepts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
	
	public UserNotFound(String msg){
		super(msg);
	}

}
