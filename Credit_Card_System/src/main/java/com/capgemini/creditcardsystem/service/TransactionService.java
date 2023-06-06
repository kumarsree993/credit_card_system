package com.capgemini.creditcardsystem.service;

import java.util.List;

import com.capgemini.creditcardsystem.dto.TransactionDto;

public interface TransactionService {

	TransactionDto addTransaction(int custId, int cardNumber, TransactionDto transaction);

	List<TransactionDto> getAllTransaction();

	TransactionDto getTransactionById(int transactionId);

	TransactionDto getTransactionByCardNumber(int cardNumber);

	List<TransactionDto> getAllTransactionByCustomerId(int customerId);

}
