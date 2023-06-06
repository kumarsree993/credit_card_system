package com.capgemini.creditcardsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.creditcardsystem.dto.TransactionDto;
import com.capgemini.creditcardsystem.exception.CardHolderNotFoundException;
import com.capgemini.creditcardsystem.model.CardHolder;
import com.capgemini.creditcardsystem.model.Transaction;
import com.capgemini.creditcardsystem.repository.CardHolderRepository;
import com.capgemini.creditcardsystem.repository.CreditCardRepository;
import com.capgemini.creditcardsystem.repository.CustomerRepository;
import com.capgemini.creditcardsystem.repository.TransactionRepository;
import com.capgemini.creditcardsystem.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	CardHolderRepository cardHolderRepo;

	@Autowired
	ModelMapper mapper;

	@Override
	public TransactionDto addTransaction(int custId, int cardNumber, TransactionDto transactionDto) {

		/*
		 * Transaction transaction = mapper.map(transactionDto, Transaction.class);
		 * 
		 * CardHolder cardHolder = cardHolderRepo.findById(cardNumber).orElseThrow(() ->
		 * new CardHolderNotFoundException());
		 * 
		 * transaction.setCardHolder(cardHolder);
		 * 
		 * Transaction newTransaction = transactionRepo.save(transaction);
		 * 
		 * return mapper.map(newTransaction, TransactionDto.class);
		 */
		return null;
	}

	@Override
	public List<TransactionDto> getAllTransaction() {

		List<Transaction> transactionData = transactionRepo.findAll();
		return transactionData.stream().map(transaction -> mapper.map(transaction, TransactionDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDto getTransactionById(int transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDto getTransactionByCardNumber(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDto> getAllTransactionByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
