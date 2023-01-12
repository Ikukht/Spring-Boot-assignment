package com.example.CapgeminiREST.service;

import com.example.CapgeminiREST.model.Transaction;

public interface TransactionService {
	
	public Transaction createTransaction(Long accountId, Transaction transaction) throws Exception;
	
}
