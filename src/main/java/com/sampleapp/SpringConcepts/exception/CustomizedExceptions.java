package com.sampleapp.SpringConcepts.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sampleapp.SpringConcepts.entity.ErrorDetails;


@ControllerAdvice
public class CustomizedExceptions extends ResponseEntityExceptionHandler{
    
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){
        
        ErrorDetails err = new ErrorDetails(LocalDate.now() , ex.getMessage() , "Test");
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_ACCEPTABLE);
        
    }

	@ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFound ex, WebRequest request) throws Exception{
        
        ErrorDetails err = new ErrorDetails(LocalDate.now() , ex.getMessage() , "Test");
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_ACCEPTABLE);
        
    }
}

