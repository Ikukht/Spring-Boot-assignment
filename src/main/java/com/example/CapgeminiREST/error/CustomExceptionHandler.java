package com.example.CapgeminiREST.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> dataNotFoundExceptionHandling(ResourceNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), "Not found error", exception.getMessage()), HttpStatus.NOT_FOUND);
    }
    
}