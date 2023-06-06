package com.capgemini.creditcardsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.creditcardsystem.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
