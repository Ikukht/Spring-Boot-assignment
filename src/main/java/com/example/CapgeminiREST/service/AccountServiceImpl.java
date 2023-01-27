package com.example.CapgeminiREST.service;

import java.math.BigDecimal;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CapgeminiREST.dto.AccountDTO;
import com.example.CapgeminiREST.dto.CustomerDTO;
import com.example.CapgeminiREST.dto.TransactionDTO;
import com.example.CapgeminiREST.error.ResourceNotFoundException;
import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Customer;
import com.example.CapgeminiREST.model.Transaction;
import com.example.CapgeminiREST.repository.AccountRepository;
import com.example.CapgeminiREST.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRep;
	@Autowired
	private CustomerRepository customerRep;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TransactionService transactionService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	public CustomerDTO getUserInfo(Long customerId) throws ResourceNotFoundException {
		Customer customer = customerRep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Could not find customer id: " + customerId));
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public AccountDTO openAccount(Long customerId, TransactionDTO transaction) throws ResourceNotFoundException {
		Customer customer = customerRep.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Could not find customer id: " + customerId));
		Account account = new Account();
		account.setCustomer(customer);
		Account newAccount = accountRep.save(account);
		LOG.info("init credit: " + transaction.getInitialCredit() + " " );
		if (!transaction.getInitialCredit().equals(BigDecimal.ZERO)) {
			// Might not be the best approach to use service inside another service as it creates circular dependency
			TransactionDTO newTransaction = transactionService.createTransaction(newAccount.getId(), transaction);
			newAccount.setTransactions(Arrays.asList(modelMapper.map(newTransaction, Transaction.class)));
			newAccount.setBalance(newTransaction.getInitialCredit());
			LOG.info("Transaction created: " + newTransaction.toString());
		}
		LOG.info("Account created: " + newAccount.toString());
		return modelMapper.map(newAccount, AccountDTO.class);
	}
}