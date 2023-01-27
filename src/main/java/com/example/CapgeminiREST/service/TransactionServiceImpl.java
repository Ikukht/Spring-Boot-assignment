package com.example.CapgeminiREST.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CapgeminiREST.dto.TransactionDTO;
import com.example.CapgeminiREST.error.ResourceNotFoundException;
import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Transaction;
import com.example.CapgeminiREST.repository.AccountRepository;
import com.example.CapgeminiREST.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRep;
	@Autowired
	private AccountRepository accountRep;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TransactionDTO createTransaction(Long accountId, TransactionDTO transaction) throws ResourceNotFoundException {
		Transaction newTransaction = modelMapper.map(transaction, Transaction.class);
		Account account = accountRep.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Could not find related account with id: " + accountId));
		newTransaction.setAccount(account);
		return modelMapper.map(transactionRep.save(newTransaction), TransactionDTO.class);
	}
}
