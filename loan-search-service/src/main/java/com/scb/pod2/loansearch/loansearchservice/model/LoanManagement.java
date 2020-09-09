package com.scb.pod2.loansearch.loansearchservice.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Entity
public class LoanManagement {

	@Id
	@GeneratedValue
	private Long loanNumber;

	private Double loanAmount;

	private String borrowerName;


	public Long getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Long loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	

	public LoanManagement() {
		super();
	}

	public LoanManagement(Long loanNumber, String borrowerName, Double loanAmount) {
		super();
		this.loanNumber = loanNumber;
		this.loanAmount = loanAmount;
		this.borrowerName = borrowerName;
	}

	
}