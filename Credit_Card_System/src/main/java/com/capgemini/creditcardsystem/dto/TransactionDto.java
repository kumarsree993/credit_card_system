package com.capgemini.creditcardsystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

	private int transactionId;
	private LocalDate transactionDate;
	private String status;
	private double amount;

}
