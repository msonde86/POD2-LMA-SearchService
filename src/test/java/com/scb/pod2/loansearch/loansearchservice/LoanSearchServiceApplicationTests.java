package com.scb.pod2.loansearch.loansearchservice;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoanSearchServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	static String expectedlistAll = "[{\"loanNumber\":1000,\"loanAmount\":12000.0,\"borrowerName\":\"Thejas G M\"},{\"loanNumber\":1001,\"loanAmount\":150000.0,\"borrowerName\":\"Mithila S\"},{\"loanNumber\":1002,\"loanAmount\":200000.0,\"borrowerName\":\"Pushpa\"},{\"loanNumber\":1003,\"loanAmount\":100000.0,\"borrowerName\":\"Bharat\"},{\"loanNumber\":1004,\"loanAmount\":100000.0,\"borrowerName\":\"Vinoth\"},{\"loanNumber\":1005,\"loanAmount\":120000.0,\"borrowerName\":\"Pushpa\"}]";

	@Test
	void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/loan/data", String.class);
		JSONAssert.assertEquals(expectedlistAll, response, false);
	}

}
