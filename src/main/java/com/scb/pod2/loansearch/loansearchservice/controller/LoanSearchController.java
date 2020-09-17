package com.scb.pod2.loansearch.loansearchservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.pod2.loansearch.loansearchservice.exception.LoanManagementDataNotFound;
import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;
import com.scb.pod2.loansearch.loansearchservice.service.LoanSearchService;

@CrossOrigin
@RestController
public class LoanSearchController {


	@Autowired
	private LoanSearchService service;

	/**
	 * retrieve all the loan data
	 * 
	 * @return List --returns list of loan data.
	 * @throws Exception
	 */
	@GetMapping("/loan/data")
	public List<LoanManagement> retrieveAllLoanData() {

		List<LoanManagement> userOptional = service.retriveAllLoanMangement();
		return userOptional;
	}

	/**
	 * filter the loan data based on the the parameter such as loan number, borrower
	 * name, and loan amount , return the result in the of list of loan data
	 * 
	 * @param number   -- loan number of long type
	 * @param borrower -- borrower name of string type
	 * @param amount   --loan amount of double type
	 * @return List --returns after the filter based on the parameter.
	 * 
	 * 
	 */

	@GetMapping("/loan/data/filter")
	public List<LoanManagement> filterLoanData(@RequestParam Optional<Long> number,
			@RequestParam Optional<String> borrower, @RequestParam Optional<Double> amount) {

		Optional<List<LoanManagement>> loanData = Optional.ofNullable(service.retriveAllLoanMangement());

		if (loanData.isPresent() && number.isPresent()) {
			loanData = Optional.ofNullable(loanData.get().stream()
						.filter(obj -> (long) obj.getLoanNumber() == (long) number.get())
						.collect(Collectors.toList()));
		}

		if (loanData.isPresent() && borrower.isPresent()) {
			loanData = Optional.ofNullable(loanData.get().stream()
						.filter(obj -> obj.getBorrowerName().equalsIgnoreCase(borrower.get()))
						.collect(Collectors.toList()));
		}

		if (loanData.isPresent() && amount.isPresent()) {
			loanData = Optional.ofNullable(loanData.get().stream()
					.filter(obj -> (double) obj.getLoanAmount() == (double) amount.get())
					.collect(Collectors.toList()));
		}

		if (!loanData.isPresent() || loanData.get().isEmpty()) {
			throw new LoanManagementDataNotFound("No Search Results");
		}
		return loanData.get();
	}

}