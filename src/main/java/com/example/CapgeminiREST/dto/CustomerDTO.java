package com.example.CapgeminiREST.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class CustomerDTO {
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@Valid
	private List<AccountDTO> accounts;
	
	public CustomerDTO() {

	}
	
	public CustomerDTO(String name, String surname, List<AccountDTO> accounts) {
		this.name = name;
		this.surname = surname;
		this.accounts = accounts;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}
	
	public List<AccountDTO> getAccounts() {
		return accounts;
	}
}
