package com.example.CapgeminiREST.service;

import com.example.CapgeminiREST.dto.TransactionDTO;
import com.example.CapgeminiREST.error.ResourceNotFoundException;

public interface TransactionService {
	
	public TransactionDTO createTransaction(Long accountId, TransactionDTO transaction) throws ResourceNotFoundException;
	
}
