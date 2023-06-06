package com.capgemini.creditcardsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.creditcardsystem.model.Customer;
import com.capgemini.creditcardsystem.repository.CustomerRepository;

@Component
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

}
