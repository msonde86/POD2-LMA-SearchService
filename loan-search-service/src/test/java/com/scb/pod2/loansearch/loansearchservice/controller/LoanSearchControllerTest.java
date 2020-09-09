package com.scb.pod2.loansearch.loansearchservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;
import com.scb.pod2.loansearch.loansearchservice.service.LoanSearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanSearchController.class)
public class LoanSearchControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoanSearchService loanSearchService;

	static List<LoanManagement> expectedlistAll = new ArrayList<LoanManagement>();

	static List<LoanManagement> expectListFilter = new ArrayList<LoanManagement>();

	static {

		expectedlistAll.add(new LoanManagement(1000l, "Thejas G M", 12000.0d));
		expectedlistAll.add(new LoanManagement(1001l, "Mithila S", 150000.0d));
		expectedlistAll.add(new LoanManagement(1002l, "Pushpa", 200000.0d));
		expectedlistAll.add(new LoanManagement(1003l, "Bharat", 100000.0d));
		expectedlistAll.add(new LoanManagement(1004l, "Vinoth", 100000.0d));

		expectListFilter.add(new LoanManagement(1000l, "Thejas G M", 12000.0d));
	}

	@Test
	public void retrieveAllLoanData_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders
				.get("/loan/data")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[]"))
				.andReturn();

	}
	
	 @Test
     public void retrieveAllLoanDataTest() throws Exception {

                    when( loanSearchService.retriveAllLoanMangement()).
                    thenReturn(expectedlistAll);

                    RequestBuilder request=MockMvcRequestBuilders.get("/loan/data").accept(MediaType.APPLICATION_JSON);

                    mockMvc.perform(request)
                    		.andExpect(status().isOk())
                    		.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"},{\"loanNumber\":1001,\"loanAmount\":150000.0,\"borrowerName\":\"Mithila S\"},{\"loanNumber\":1002,\"loanAmount\":200000.0,\"borrowerName\":\"Pushpa\"},{\"loanNumber\":1003,\"loanAmount\":100000.0,\"borrowerName\":\"Bharat\"},{\"loanNumber\":1004,\"loanAmount\":100000.0,\"borrowerName\":\"Vinoth\"}]"))
                    		.andReturn();

	 }


	@Test
	public void filterLoanDataByAll() throws Exception {

        when( loanSearchService.retriveAllLoanMangement()).
        thenReturn(expectListFilter);

        RequestBuilder request=MockMvcRequestBuilders.get("/loandata/filter")
        				.param("number", "1000")
        				.param("borrower","thejas g m")
        				.param("amount","12000.0")
        				.accept(MediaType.APPLICATION_JSON);

       mockMvc.perform(request)
       .andExpect(status().isOk())
       .andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
       .andReturn();

}
	
	@Test
	public void filterLoanDataByNumber() throws Exception {

		when(loanSearchService.retriveAllLoanMangement())
		.thenReturn(expectListFilter);
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("number", "1000")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();

	}


	@Test
	public void filterLoanDataByName() throws Exception {

		when(loanSearchService.retriveAllLoanMangement()).
		thenReturn(expectListFilter);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("borrower", "thejas g m")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();

	}


	@Test
	public void filterLoanDataByAmount() throws Exception {

		when(loanSearchService.retriveAllLoanMangement())
		.thenReturn(expectListFilter);
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("amount","12000.0")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();


	}

	@Test
	public void filterLoanDataByNumberAndName() throws Exception {

		when(loanSearchService.retriveAllLoanMangement())
		.thenReturn(expectListFilter);
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("number", "1000")
				.param("borrower", "thejas g m")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();

	}

	@Test
	public void filterLoanDataByNumberAndAmount() throws Exception {

		when(loanSearchService.retriveAllLoanMangement())
		.thenReturn(expectListFilter);
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("number", "1000")
				.param("amount","12000.0")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();

	}

	@Test
	public void filterLoanDataByNameAndAmount() throws Exception {

		when(loanSearchService.retriveAllLoanMangement())
		.thenReturn(expectListFilter);
		RequestBuilder request = MockMvcRequestBuilders.get("/loandata/filter")
				.param("amount","12000.0")
				.param("borrower", "thejas g m")
				.accept(MediaType.APPLICATION_JSON);
		//MvcResult result = mockMvc.perform(request)
		 mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"}]"))
				.andReturn();

	}

}
