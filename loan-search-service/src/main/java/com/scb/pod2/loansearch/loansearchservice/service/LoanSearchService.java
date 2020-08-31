package com.scb.pod2.loansearch.loansearchservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.scb.pod2.loansearch.loansearchservice.dao.LoanSearchRepository;
import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@Service

public class LoanSearchService {

	@Autowired

	private LoanSearchRepository loanManagementDAO;

	public List<LoanManagement> retriveAllLoanMangement() {

		return loanManagementDAO.findAll();

	}

	public Optional<LoanManagement> retriveLoanMangementByNumber(long id) {

		return loanManagementDAO.findById(id);

	}

	public List<LoanManagement> findByBorrowerName(String borrowerName) {

		return loanManagementDAO.searchByBorrowerName(borrowerName);

	}

	public List<LoanManagement> findByLoanAmount(double loanAmount) {

		return loanManagementDAO.findByLoanAmount(loanAmount);

	}

	public List<LoanManagement> findByLoanNumberAndLoanAmount(long loanNumber, double amount) {

		return loanManagementDAO.findByLoanNumberAndLoanAmount(loanNumber, amount);

	}

	public List<LoanManagement> searchByLoanNumberAndBorrowerName(long loanNumber, String borrowerName) {

		return loanManagementDAO.searchByLoanNumberAndBorrowerName(loanNumber, borrowerName);

	}

	public List<LoanManagement> searchByBorrowerNameAndAmount(String borrowerName, double loanAmount) {

		return loanManagementDAO.searchByBorrowerNameAndAmount(borrowerName, loanAmount);

	}

	public List<LoanManagement> searchLoanData(long loanNumber, String borrowerName, double amount) {

		return loanManagementDAO.searchLoanData(loanNumber, borrowerName, amount);

	}

}