package com.scb.pod2.loansearch.loansearchservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanManagement {

	@Id
	@GeneratedValue
	private Long loanNumber;

	private Double loanAmount;

	private String borrowerName;

}
