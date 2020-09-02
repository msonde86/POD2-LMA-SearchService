package com.scb.pod2.loansearch.loansearchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;
import com.scb.pod2.loansearch.loansearchservice.service.LoanSearchService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SpringRunner.class)
@WebMvcTest(LoanSearchController.class)
public class LoanSearchControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private LoanSearchService loanSearchService;
	
	List<LoanManagement> list;
	@Test
	public void retrieveAllLoanDataTest() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loanmanagement/data").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		

	}
	@Test
	public void searchLoanDataByID(@PathVariable Long number) throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loanmanagement/data").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	
	@Test
	public void filterLoanDataByAll() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}

	
	@Test
	public void filterLoanDataByName() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	
	@Test
	public void filterLoanDataByNumber() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	@Test
	public void filterLoanDataByAmount() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	
	@Test
	public void filterLoanDataByNumberAndName() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	@Test
	public void filterLoanDataByNumberAndAmount() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}
	@Test
	public void filterLoanDataByNameAndAmount() throws Exception {

		when( loanSearchService.retriveAllLoanMangement()).
		thenReturn(list);
		RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter").param("number", "1000")
				.param("borrower","thejas g m").param("amount","1200000").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(""))
				.andReturn();
		



	}

}
