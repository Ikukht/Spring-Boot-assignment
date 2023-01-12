package com.example.CapgeminiREST.error;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String error;
    private String message;
    
    public ErrorDetails() {
    	
    }
    
    public ErrorDetails(Date timestamp, String error, String message) {
    	this.timestamp = timestamp;
    	this.error = error;
    	this.message = message;
    }
    
    public void setTimestamp(Date timestamp) {
    	this.timestamp = timestamp;
    }
    
    public Date getTimestamp() {
    	return timestamp;
    }
    
    public void setError(String error) {
    	this.error = error;
    }
    
    public String getError() {
    	return error;
    }
    
    public void setMessage(String message) {
    	this.message = message;
    }
    
    public String getMessage() {
    	return message;
    }
}