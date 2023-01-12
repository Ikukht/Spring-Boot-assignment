package com.example.CapgeminiREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Transaction createTransaction(Long accountId, Transaction transaction) throws Exception {
		Account account = accountRep.findById(accountId).orElseThrow(() -> new Exception("Could not find related account with id: " + accountId));
		transaction.setAccount(account);
		return transactionRep.save(transaction);
	}
}
