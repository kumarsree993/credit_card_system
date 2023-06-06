package com.capgemini.creditcardsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.creditcardsystem.model.CreditCard;
import com.capgemini.creditcardsystem.repository.CreditCardRepository;

@Component
public class CreditCardDao {
	
	@Autowired
	CreditCardRepository repo;
	
	public CreditCard createCreditCard(CreditCard creditCard) {
		return repo.save(creditCard);
	}

}
