package com.scb.pod2.loansearch.loansearchservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.scb.pod2.loansearch.loansearchservice.model.LoanManagement;

@Repository

public interface LoanSearchRepository extends JpaRepository<LoanManagement, Long> {

	List<LoanManagement> findByLoanAmount(double loanAmount);

	List<LoanManagement> findByLoanNumberAndLoanAmount(long loanNumber, double amount);

	@Query("From LoanManagement lm where lower(lm.borrowerName)=:borrowerName ")

	List<LoanManagement> searchByBorrowerName(@Param("borrowerName") String borrowerName);

	@Query("From LoanManagement lm where lm.loanNumber=:loanNumber and lower(lm.borrowerName)=:borrowerName ")

	List<LoanManagement> searchByLoanNumberAndBorrowerName(@Param("loanNumber") long loanNumber,
			@Param("borrowerName") String borrowerName);

	@Query("From LoanManagement lm where lm.loanAmount=:loanAmount and lower(lm.borrowerName)=:borrowerName ")

	List<LoanManagement> searchByBorrowerNameAndAmount(@Param("borrowerName") String borrowerName,
			@Param("loanAmount") double loanAmount);

	@Query("From LoanManagement lm where lm.loanAmount=:loanAmount and lower(lm.borrowerName)=:borrowerName and  lm.loanNumber=:loanNumber ")

	List<LoanManagement> searchLoanData(@Param("loanNumber") long loanNumber,
			@Param("borrowerName") String borrowerName, @Param("loanAmount") double loanAmount);

}