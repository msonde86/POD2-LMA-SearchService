package com.scb.pod2.loansearch.loansearchservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoanSearchServiceApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	static List<LoanManagement> expectedlistAll = new ArrayList<LoanManagement>(); 

	@Test
	void contextLoads() throws JSONException {
		String response=this.restTemplate.getForObject("/loan/data",String.class);
	JSONAssert.assertEquals(expectedlistAll.toString(), response, false);
	}
	
	static {

		expectedlistAll.add(new LoanManagement(1000l, "Thejas G M", 12000.0d));
		expectedlistAll.add(new LoanManagement(1001l, "Mithila S", 150000.0d));
		expectedlistAll.add(new LoanManagement(1002l, "Pushpa", 200000.0d));
		expectedlistAll.add(new LoanManagement(1003l, "Bharat", 100000.0d));
		expectedlistAll.add(new LoanManagement(1004l, "Vinoth", 100000.0d));
		expectedlistAll.add(new LoanManagement(1005l, "Pushpa", 120000.0d));

		
	}

}
