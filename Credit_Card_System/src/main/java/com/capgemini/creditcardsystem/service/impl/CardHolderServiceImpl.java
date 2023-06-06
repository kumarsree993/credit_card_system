package com.capgemini.creditcardsystem.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.creditcardsystem.dto.CardHolderDto;
import com.capgemini.creditcardsystem.exception.CardHolderNotFoundException;
import com.capgemini.creditcardsystem.exception.CreditCardNotFoundException;
import com.capgemini.creditcardsystem.exception.CustomerNotFoundException;
import com.capgemini.creditcardsystem.model.CardHolder;
import com.capgemini.creditcardsystem.model.CreditCard;
import com.capgemini.creditcardsystem.model.Customer;
import com.capgemini.creditcardsystem.repository.CardHolderRepository;
import com.capgemini.creditcardsystem.repository.CreditCardRepository;
import com.capgemini.creditcardsystem.repository.CustomerRepository;
import com.capgemini.creditcardsystem.service.CardHolderService;

@Service
public class CardHolderServiceImpl implements CardHolderService{
	
	@Autowired
	CardHolderRepository cardHolderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CreditCardRepository creditCardRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CardHolderDto allotCreditCard(int customerId, int creditCardId,  CardHolderDto cardHolderDto) {
		
		CardHolder cardHolder = mapper.map(cardHolderDto, CardHolder.class);
		
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException());
		
		CreditCard creditCard = creditCardRepo.findById(creditCardId).orElseThrow(() -> new CreditCardNotFoundException());
		
		cardHolder.setCustomer(customer);
		cardHolder.setCreditCard(creditCard);
		
		CardHolder newCardHolder = cardHolderRepo.save(cardHolder);
		
		return mapper.map(newCardHolder, CardHolderDto.class);
	}

	@Override
	public CardHolderDto getCreditCardByCardNo(int cardNumber) {
		
		CardHolder cardHolder = cardHolderRepo.findById(cardNumber).orElseThrow(() -> new CardHolderNotFoundException());
		return mapper.map(cardHolder, CardHolderDto.class);
	}


}
