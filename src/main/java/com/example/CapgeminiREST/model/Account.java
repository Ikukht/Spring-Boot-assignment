package com.example.CapgeminiREST.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	
	@Transient
	private BigDecimal balance = BigDecimal.ZERO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Transaction> transactions = new ArrayList<>();
	
	public Account() {}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	@PostLoad
	private void onLoad() {
	    for(Transaction tran : transactions) {
			this.balance = this.balance.add(tran.getInitialCredit());
	    }
	}
	
	@Override
	public String toString() {
	    return "Account {id=" + this.id + ", balance=" + this.balance + ", customer_id=" + customer.getId() + "}";
	}
}