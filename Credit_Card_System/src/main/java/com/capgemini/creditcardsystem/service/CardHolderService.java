package com.capgemini.creditcardsystem.service;

import com.capgemini.creditcardsystem.dto.CardHolderDto;

public interface CardHolderService {

	public CardHolderDto allotCreditCard(int customerId, int creditCardId, CardHolderDto cardHolder);

	CardHolderDto getCreditCardByCardNo(int cardNumber);

}
