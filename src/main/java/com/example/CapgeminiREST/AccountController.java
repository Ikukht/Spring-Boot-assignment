package com.example.CapgeminiREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapgeminiREST.dto.AccountDTO;
import com.example.CapgeminiREST.dto.CustomerDTO;
import com.example.CapgeminiREST.dto.TransactionDTO;
import com.example.CapgeminiREST.error.ResourceNotFoundException;
import com.example.CapgeminiREST.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("customers/{id}")
	public CustomerDTO getUserInfo(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return accountService.getUserInfo(id);
	}
	
	@PostMapping("customers/{id}/accounts")
	public AccountDTO createAccount(@PathVariable("id") Long id, @Valid @RequestBody TransactionDTO transaction) throws ResourceNotFoundException {
		return accountService.openAccount(id, transaction);
	}
}