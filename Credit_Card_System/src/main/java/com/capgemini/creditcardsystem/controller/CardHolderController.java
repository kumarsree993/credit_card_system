package com.capgemini.creditcardsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.creditcardsystem.dto.CardHolderDto;
import com.capgemini.creditcardsystem.service.CardHolderService;

@RestController
@RequestMapping("/cardholderapi")
public class CardHolderController {

	@Autowired
	CardHolderService service;

	@PostMapping("/allotCreditCard/{customerId}/{creditCardId}")
	public ResponseEntity<CardHolderDto> allotCreditCard(@PathVariable int customerId, @PathVariable int creditCardId,
			@RequestBody CardHolderDto cardHolder) {

		CardHolderDto cardHolderDto = service.allotCreditCard(customerId, creditCardId, cardHolder);
		return new ResponseEntity<CardHolderDto>(cardHolderDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/cardHolders/{cardNumber}")
	public ResponseEntity<CardHolderDto> getCreditCardByCardNo(@PathVariable int cardNumber){
		return new ResponseEntity<CardHolderDto>(service.getCreditCardByCardNo(cardNumber), HttpStatus.FOUND);
	}
	
}
