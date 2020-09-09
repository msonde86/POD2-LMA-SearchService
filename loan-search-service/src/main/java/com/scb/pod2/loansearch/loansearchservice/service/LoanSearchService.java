package com.scb.pod2.loansearch.loansearchservice.service;

import java.util.List;

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

}