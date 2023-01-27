package com.example.CapgeminiREST.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class AccountDTO {
	@NotNull
	private BigDecimal balance;
    @Valid
	private List<TransactionDTO> transactions;
	
	public AccountDTO() {

	}
	
	public AccountDTO(BigDecimal balance, CustomerDTO customer, List<TransactionDTO> transactions) {
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}
	
	public List<TransactionDTO> getTransactions() {
		return transactions;
	}
}
