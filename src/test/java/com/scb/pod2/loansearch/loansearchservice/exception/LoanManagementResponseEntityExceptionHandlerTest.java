package com.scb.pod2.loansearch.loansearchservice.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

@RunWith(SpringRunner.class)
public class LoanManagementResponseEntityExceptionHandlerTest {
	
	private LoanManagementResponseEntityExceptionHandler lmree = new LoanManagementResponseEntityExceptionHandler();
	
	@Mock
	private WebRequest webRequest;
	
	@Test
	public void testHandleAllException() {
		ResponseEntity re = lmree.handleAllException(Mockito.mock(Exception.class), webRequest);
		
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, re.getStatusCode());
	}
	
	@Test
	public void testHandle() {
		ResponseEntity re = lmree.handle(Mockito.mock(IllegalArgumentException.class), webRequest);
		
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, re.getStatusCode());
	}
}
