package com.scb.pod2.loansearch.loansearchservice.controller;

import java.util.List;

import java.util.Optional;

import java.util.stream.Collectors;

//import org.slf4j.Logger;
//
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;
import com.scb.pod2.loansearch.loansearchservice.service.LoanSearchService;

@CrossOrigin

@RestController

public class LoanSearchController {

	// private Logger logger = LoggerFactory.getLogger(LoanSearchController.class);

	@Autowired

	private LoanSearchService service;

	@GetMapping("/loan/data")

	public List<LoanManagement> retrieveAllLoanData() {

		List<LoanManagement> userOptional = service.retriveAllLoanMangement();

		return userOptional;

	}

	
	@GetMapping("/loandata/filter")

	public List<LoanManagement> filterLoanData(@RequestParam Optional<Long> number, @RequestParam Optional<String> borrower,

			@RequestParam Optional<Double >amount) {

		Optional<List<LoanManagement>> loanData = Optional.ofNullable(service.retriveAllLoanMangement());

		if (loanData.isPresent() && number.isPresent()) {

			loanData = Optional.ofNullable(loanData.get().stream().filter(obj -> (long)obj.getLoanNumber() ==(long) number.get()).collect(Collectors.toList()));

		}

		if (loanData.isPresent() && borrower.isPresent()) {

			loanData = Optional.ofNullable(loanData.get().stream().filter(obj -> obj.getBorrowerName().equalsIgnoreCase(borrower.get())).collect(Collectors.toList()));

		}

		if (loanData.isPresent() && amount.isPresent()) {

			loanData = Optional.ofNullable(loanData.get().stream().filter(obj -> obj.getLoanAmount() == amount.get()).collect(Collectors.toList()));

		}

		return loanData.isPresent() ? loanData.get() : null;

	}


	@GetMapping("loan/data/number/{number}")

	public LoanManagement searchLoanDataByID(@PathVariable Long number) {

		return service.retriveLoanMangementByNumber(number).orElse(null);

	}

	
	@GetMapping("loan/data/amount/{amount}")

	public List<LoanManagement> searchLoanDataByAmount(@PathVariable double amount) {

		return service.findByLoanAmount(amount);

	}

	@GetMapping("loan/data/name/{borrower}")

	public List<LoanManagement> searchLoanDataByBorrowerName(@PathVariable String borrower) {

		return service.findByBorrowerName(borrower.toLowerCase());

	}

	@GetMapping("loan/data/number/{loanNumber}/borrower/{borrower}")

	public List<LoanManagement> searchLoanDataByNumberAndBorrowerName(@PathVariable long loanNumber,

			@PathVariable String borrower) {

		return service.searchByLoanNumberAndBorrowerName(loanNumber, borrower.toLowerCase());

	}

	@GetMapping("loan/data/number/{loanNumber}/amount/{amount}")

	public List<LoanManagement> searchLoanDataByNumberAndAmount(@PathVariable long loanNumber,

			@PathVariable double amount) {

		return service.findByLoanNumberAndLoanAmount(loanNumber, amount);

	}

	@GetMapping("loan/data/borrower/{borrower}/amount/{amount}")

	public List<LoanManagement> searchByBorrowerNameAndAmount(String borrowerName, double amount) {

		return service.searchByBorrowerNameAndAmount(borrowerName.toLowerCase(), amount);

	}

	@GetMapping("loan/data/number/{number}/borrowers/{borrower}/amount/{amount}")

	public List<LoanManagement> searchLoanData(long number, String borrower, double amount) {

		return service.searchLoanData(number, borrower.toLowerCase(), amount);

	}

}