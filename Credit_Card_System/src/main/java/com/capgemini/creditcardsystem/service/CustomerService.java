package com.capgemini.creditcardsystem.service;

import java.util.List;

import com.capgemini.creditcardsystem.dto.CustomerDto;

public interface CustomerService {

	List<CustomerDto> getAllCustomers();

	CustomerDto getCustomerById(int customerId);

	CustomerDto addCustomer(CustomerDto dto);

	String deleteCustomer(int customerId);

	CustomerDto updateCustomer(int customerId, CustomerDto customer);

}
