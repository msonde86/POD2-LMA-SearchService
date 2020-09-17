package com.scb.pod2.loansearch.loansearchservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@Repository
public interface LoanSearchRepository extends JpaRepository<LoanManagement, Long> {

	}