package com.capgemini.creditcardsystem.service;

import java.util.List;

import com.capgemini.creditcardsystem.dto.CreditCardDto;


public interface CreditCardService {

	CreditCardDto getCreditCardById(int creditcardId);

	public CreditCardDto saveCreditCard(CreditCardDto dto);

	public String deleteCreditCardId(int creditcardid);

	List<CreditCardDto> getAllCreditCards();

	CreditCardDto getCreditCardByType(String creditCardType);

}
