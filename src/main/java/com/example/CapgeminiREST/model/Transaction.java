package com.example.CapgeminiREST.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal initialCredit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="account_id")
	private Account account;
	
	public Transaction() {}
	
	public Transaction(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	public BigDecimal getInitialCredit() {
		return initialCredit;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	@Override
	public String toString() {
	    return "{id=" + this.id + ", initialCredit=" + this.initialCredit + ", account_id=" + account.getId() + "}";
	}
}