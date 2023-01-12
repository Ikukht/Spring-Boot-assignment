package com.example.CapgeminiREST.service;

import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Customer;

public interface AccountService {
	
	public Customer  getUserInfo(Long customerId) throws Exception;
	
	public Account openAccount(Long customerId) throws Exception;
	
}