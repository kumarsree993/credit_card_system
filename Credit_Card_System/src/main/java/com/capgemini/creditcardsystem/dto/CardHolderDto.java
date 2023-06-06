package com.capgemini.creditcardsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.capgemini.creditcardsystem.model.CardHolder;
import com.capgemini.creditcardsystem.model.CreditCard;
import com.capgemini.creditcardsystem.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardHolderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cardNumber;
	private LocalDate fromDate;
	private LocalDate toDate;
	private int secretCode;
	private String name;
	private Customer customer;
	private CreditCard creditCard;
}
