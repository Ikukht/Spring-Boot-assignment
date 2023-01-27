package com.example.CapgeminiREST.service;

import com.example.CapgeminiREST.dto.AccountDTO;
import com.example.CapgeminiREST.dto.CustomerDTO;
import com.example.CapgeminiREST.dto.TransactionDTO;
import com.example.CapgeminiREST.error.ResourceNotFoundException;

public interface AccountService {
	
	public CustomerDTO getUserInfo(Long customerId) throws ResourceNotFoundException;
	
	public AccountDTO openAccount(Long customerId, TransactionDTO transaction) throws ResourceNotFoundException;
	
}