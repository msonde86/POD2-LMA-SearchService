package com.scb.pod2.loansearch.loansearchservice.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoanManagementTest {

	@Test
	public void testLoanManagement() {
		LoanManagement lm = new LoanManagement();
		lm.setBorrowerName("Mithila");
		lm.setLoanAmount(10000d);
		lm.setLoanNumber(1001l);
		Assert.assertEquals("Mithila",lm.getBorrowerName());
		Assert.assertEquals("10000.0",lm.getLoanAmount().toString());
		Assert.assertEquals("10000.0",lm.getLoanAmount().toString());
		
		
	}

}
