package com.capgemini.creditcardsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.creditcardsystem.dao.CreditCardDao;
import com.capgemini.creditcardsystem.dto.CreditCardDto;
import com.capgemini.creditcardsystem.exception.CreditCardNotFoundException;
import com.capgemini.creditcardsystem.model.CreditCard;
import com.capgemini.creditcardsystem.repository.CreditCardRepository;
import com.capgemini.creditcardsystem.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository repo;

	@Autowired
	ModelMapper mapper;

	@Autowired
	CreditCardDao dao;

	@Override
	public CreditCardDto getCreditCardById(int creditcardId) {
		
		Optional<CreditCard> opt = repo.findById(creditcardId);
		if (!opt.isPresent()) {
			throw new CreditCardNotFoundException();
		}
		return mapper.map(opt, CreditCardDto.class);
	}

	@Override
	public CreditCardDto saveCreditCard(CreditCardDto dto) {
		CreditCard card = mapper.map(dto, CreditCard.class);
		card = dao.createCreditCard(card);
		return mapper.map(card, CreditCardDto.class);
	}

	@Override
	public String deleteCreditCardId(int creditcardid) {
		Optional<CreditCard> opt = repo.findById(creditcardid);
		if (!opt.isPresent()) {
			throw new CreditCardNotFoundException();
		}
		repo.deleteById(creditcardid);
		return "CreditCard with Id :" + creditcardid + " is deleted successfully";
	}

	@Override
	public List<CreditCardDto> getAllCreditCards() {
		List<CreditCard> cards = repo.findAll();
		List<CreditCardDto> cardDto = cards.stream().map(card -> mapper.map(card, CreditCardDto.class))
				.collect(Collectors.toList());

		return cardDto;
	}

	@Override
	public CreditCardDto getCreditCardByType(String creditCardType) {
		
		Optional<CreditCard> opt = repo.findByType(creditCardType);
		if (!opt.isPresent()) {
			throw new CreditCardNotFoundException();
		}
		return mapper.map(opt, CreditCardDto.class);
	}

}
