package com.example.CapgeminiREST.dto;

import java.math.BigDecimal;

//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionDTO {
	@NotNull
	private BigDecimal initialCredit;
	
	public TransactionDTO() {

	}
	
	public TransactionDTO(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	public BigDecimal getInitialCredit() {
		return initialCredit;
	}
}
