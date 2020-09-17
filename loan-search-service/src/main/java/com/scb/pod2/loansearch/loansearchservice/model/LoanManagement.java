package com.scb.pod2.loansearch.loansearchservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
