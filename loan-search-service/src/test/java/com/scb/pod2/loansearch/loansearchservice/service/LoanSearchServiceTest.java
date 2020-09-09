package com.scb.pod2.loansearch.loansearchservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.scb.pod2.loansearch.loansearchservice.dao.LoanSearchRepository;
import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@RunWith(MockitoJUnitRunner.class)
public class LoanSearchServiceTest {
	
	@InjectMocks
	private LoanSearchService loanSearchService;
	
	@Mock
	private LoanSearchRepository loanSearchRepository; 
	
	
	static List<LoanManagement> expectedlistAll = new ArrayList<LoanManagement>(); 

	static {

		expectedlistAll.add(new LoanManagement(1000l, "Thejas G M", 12000.0d));
		expectedlistAll.add(new LoanManagement(1001l, "Mithila S", 150000.0d));
		expectedlistAll.add(new LoanManagement(1002l, "Pushpa", 200000.0d));
		expectedlistAll.add(new LoanManagement(1003l, "Bharat", 100000.0d));
		expectedlistAll.add(new LoanManagement(1004l, "Vinoth", 100000.0d));

		
	}
	@Test
	public void retriveAllLoanMangementTest() {

		when(loanSearchRepository.findAll())
		.thenReturn(expectedlistAll);
		
		List<LoanManagement> loanDataLst=loanSearchService.retriveAllLoanMangement();
		assertEquals(5, loanDataLst.size());

	}
	
	@Test
	public void retriveLoanMangement_Test() {
		when(loanSearchRepository.findAll())
		.thenReturn(expectedlistAll);
		List<LoanManagement> loanDataLst=loanSearchService.retriveAllLoanMangement();
		assertEquals(1000, loanDataLst.get(0).getLoanNumber());

	}

}
