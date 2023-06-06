package com.capgemini.creditcardsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.creditcardsystem.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
