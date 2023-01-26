package com.example.CapgeminiREST.error;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime time;
    private String errorCode;
    private String message;
    
    public ErrorDetails() {
    	
    }
    
    public ErrorDetails(LocalDateTime time, String errorCode, String message) {
    	this.time = time;
    	this.errorCode = errorCode;
    	this.message = message;
    }
    
    public void setTime(LocalDateTime time) {
    	this.time = time;
    }
    
    public LocalDateTime getTime() {
    	return time;
    }
    
    public void setErrorCode(String errorCode) {
    	this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
    	return errorCode;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }
    
    public String getMessage() {
    	return message;
    }
}