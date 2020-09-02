package com.scb.pod2.loansearch.loansearchservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	@Test
	public void retriveAllLoanMangementTest() {

		//when(loanSearchRepository.findAll()).thenReturn(null);
		List<LoanManagement> loanDataLst=loanSearchService.retriveAllLoanMangement();
		assertEquals(4, loanDataLst.size());

	}
	

}
