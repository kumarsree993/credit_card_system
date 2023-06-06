package com.capgemini.creditcardsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.creditcardsystem.dto.CustomerDto;
import com.capgemini.creditcardsystem.exception.CustomerNotFoundException;
import com.capgemini.creditcardsystem.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customerapi")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(){
		
		List<CustomerDto> customers = null;
		ResponseEntity<List<CustomerDto>> allCustomers = null;
		
		try {
			customers = customerService.getAllCustomers();
			if(!customers.isEmpty()) {
				logger.info("List of Customers Details");
				allCustomers = new ResponseEntity<>(customers,HttpStatus.FOUND);
			}
			else {
				logger.info("Please Enter Customer Id");
				allCustomers = new ResponseEntity<>(customers,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			logger.info("Internal Server Error");
			allCustomers = new ResponseEntity<>(customers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return allCustomers;
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int customerId) {
		
		CustomerDto customer = null;
		ResponseEntity<CustomerDto> cust = null;
		try {
			customer = customerService.getCustomerById(customerId);
			if(customer != null) {
				logger.info("Customer Details with Customer Id :"+customerId);
				cust = new ResponseEntity<>(customer,HttpStatus.FOUND);
			}
			else {
				logger.info("Please Enter Customer Id");
				cust = new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			logger.info("Internal Server Error");
			cust = new ResponseEntity<>(customer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return cust;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto dto){
		
		logger.info("Customer with Id :"+dto.getCustomerId()+" created successfully");
		
		return new ResponseEntity<CustomerDto>(customerService.addCustomer(dto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("customerId") int customerId){
		logger.error("Customer with Id :"+ customerId+" is deleted");
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<CustomerDto>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable int customerId, @RequestBody CustomerDto customer){
		CustomerDto opt = customerService.getCustomerById(customerId);
		if(opt == null) {
			throw new CustomerNotFoundException();
		}
		CustomerDto c = customerService.updateCustomer(customerId, customer);
		return new ResponseEntity<CustomerDto>(c, HttpStatus.ACCEPTED);
	}

}











