package com.capgemini.creditcardsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.creditcardsystem.dto.CreditCardDto;
import com.capgemini.creditcardsystem.service.CreditCardService;

@RestController
@RequestMapping("/creditcardapi")
public class CreditCardController {

	@Autowired
	CreditCardService service;

	@PostMapping("/creditCards")
	public ResponseEntity<CreditCardDto> addCreditCard(@RequestBody CreditCardDto dto) {
		return new ResponseEntity<CreditCardDto>(service.saveCreditCard(dto), HttpStatus.CREATED);
	}

	@GetMapping("/creditCards/{id}")
	public ResponseEntity<CreditCardDto> getById(@PathVariable int id) {
		return new ResponseEntity<CreditCardDto>(service.getCreditCardById(id), HttpStatus.FOUND);
	}

	@GetMapping("/creditCards/{type}")
	public ResponseEntity<CreditCardDto> getByType(@PathVariable String type) {
		return new ResponseEntity<CreditCardDto>(service.getCreditCardByType(type), HttpStatus.FOUND);
	}

	@GetMapping("/creditCards")
	public ResponseEntity<List<CreditCardDto>> getAll() {
		return new ResponseEntity<List<CreditCardDto>>(service.getAllCreditCards(), HttpStatus.FOUND);
	}

	@DeleteMapping("/creditCards/{id}")
	public ResponseEntity<CreditCardDto> deleteCreditCard(@PathVariable int id) {
		service.deleteCreditCardId(id);
		return new ResponseEntity<CreditCardDto>(HttpStatus.NO_CONTENT);
	}

}
