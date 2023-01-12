package com.example.CapgeminiREST;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Customer;
import com.example.CapgeminiREST.model.Transaction;
import com.example.CapgeminiREST.service.AccountService;
import com.example.CapgeminiREST.service.TransactionService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	TransactionService transactionService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("customers/{id}")
	public Customer getUserInfo(@PathVariable("id") Long id) throws Exception {
		return accountService.getUserInfo(id);
	}
	
	@PostMapping("customers/{id}/accounts")
	public Account createAccount(@PathVariable("id") Long id, @RequestBody Transaction transaction) throws Exception {
		Account newAccount = accountService.openAccount(id);
		LOG.info("init credit: " + transaction.getInitialCredit() + " " );
		if (!transaction.getInitialCredit().equals(BigDecimal.ZERO)) {
			transactionService.createTransaction(newAccount.getId(), transaction);
			newAccount.setTransactions(Arrays.asList(transaction));
			newAccount.setBalance(transaction.getInitialCredit());
			LOG.info("Transaction created: " + transaction.toString());
		}
		LOG.info("Account created: " + newAccount.toString());

		return newAccount;
	}
}