package com.scb.pod2.loansearch.loansearchservice.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoanSearchRepositoryTest {

	@Autowired
private LoanSearchRepository loanSearchRepository;

@Test
public void testFindAll() {
	List<LoanManagement> loanDataLst=loanSearchRepository.findAll();
	assertEquals(6, loanDataLst.size());
}


}
