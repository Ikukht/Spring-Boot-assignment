package com.example.CapgeminiREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CapgeminiREST.error.ResourceNotFoundException;
import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Customer;
import com.example.CapgeminiREST.repository.AccountRepository;
import com.example.CapgeminiREST.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRep;
	@Autowired
	private CustomerRepository customerRep;
	
	public Customer getUserInfo(Long customerId) throws ResourceNotFoundException {
		return customerRep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Could not find customer id: " + customerId));
	}

	@Override
	public Account openAccount(Long customerId) throws ResourceNotFoundException {
		Customer customer = customerRep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Could not find customer id: " + customerId));
    	Account account = new Account();
    	account.setCustomer(customer);
    	accountRep.save(account);
    	
		return accountRep.save(account);
	}
}