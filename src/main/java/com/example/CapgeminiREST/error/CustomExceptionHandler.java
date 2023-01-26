package com.example.CapgeminiREST.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> dataNotFoundExceptionHandling(ResourceNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ErrorCode.RESOURCE_NOT_FOUND, "Could not locate the resource"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unexpectedExceptionHandling(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ErrorCode.UNEXPECTED_ERROR, "Something unexpected happened"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}