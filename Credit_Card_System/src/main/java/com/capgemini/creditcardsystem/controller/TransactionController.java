package com.capgemini.creditcardsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.creditcardsystem.dto.TransactionDto;
import com.capgemini.creditcardsystem.service.TransactionService;

@RestController
@RequestMapping("/transactionapi")
public class TransactionController {

	@Autowired
	TransactionService service;

	@PostMapping("/addTransaction/{custId}/{cardNumber}")
	public ResponseEntity<TransactionDto> addTransaction(@PathVariable int custId, @PathVariable int cardNumber,
			@RequestBody TransactionDto transaction) {

		TransactionDto dto = service.addTransaction(custId, cardNumber, transaction);
		return new ResponseEntity<TransactionDto>(dto, HttpStatus.CREATED);

	}

	public ResponseEntity<List<TransactionDto>> getAllTransaction() {

		return new ResponseEntity<List<TransactionDto>>(service.getAllTransaction(), HttpStatus.FOUND);
	}

	public ResponseEntity<TransactionDto> getTransactionById(@PathVariable int transactionId) {

		return new ResponseEntity<TransactionDto>(service.getTransactionById(transactionId), HttpStatus.FOUND);
	}

	public ResponseEntity<TransactionDto> getTransactionByCardNumber(@PathVariable int cardNumber) {

		return new ResponseEntity<TransactionDto>(service.getTransactionByCardNumber(cardNumber), HttpStatus.FOUND);
	}
	
	public ResponseEntity<List<TransactionDto>> getAllTransactionByCustomerId(@PathVariable int customerId){
		return new ResponseEntity<List<TransactionDto>>(service.getAllTransactionByCustomerId(customerId), HttpStatus.FOUND);
	}
	
	

}
