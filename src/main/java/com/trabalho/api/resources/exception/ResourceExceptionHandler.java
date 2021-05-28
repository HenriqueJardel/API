package com.trabalho.api.resources.exception;

import javax.servlet.http.HttpServletRequest;

import com.trabalho.api.services.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> objectNotFound(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(err);
	}

}
