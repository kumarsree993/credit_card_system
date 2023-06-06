package com.capgemini.creditcardsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.creditcardsystem.dao.CustomerDao;
import com.capgemini.creditcardsystem.dto.CustomerDto;
import com.capgemini.creditcardsystem.exception.CustomerNotFoundException;
import com.capgemini.creditcardsystem.model.Customer;
import com.capgemini.creditcardsystem.repository.CustomerRepository;
import com.capgemini.creditcardsystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CustomerDao dao;

	@Override
	public List<CustomerDto> getAllCustomers() {
		
		List<Customer> customer = customerRepo.findAll();
		List<CustomerDto> customerDto = new ArrayList<>();
		
		for (Customer c : customer) {
			customerDto.add(mapper.map(c, CustomerDto.class));
		}
		return customerDto;
	}

	@Override
	public CustomerDto getCustomerById(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException());
		return mapper.map(customer, CustomerDto.class);
	}

	@Override
	public CustomerDto addCustomer(CustomerDto dto) {
		Customer c = mapper.map(dto, Customer.class);
		return mapper.map(dao.createCustomer(c), CustomerDto.class);
	}

	@Override
	public String deleteCustomer(int customerId) {
		Optional<Customer> opt = customerRepo.findById(customerId);
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException();
		}
		customerRepo.delete(opt.get());
		return "Customer with Id : " + customerId + " is deleted successfully";
	}
	
	@Override
	public CustomerDto updateCustomer(int customerId, CustomerDto dto) {
		 deleteCustomer(customerId); 
		return addCustomer(dto);
	}

}
