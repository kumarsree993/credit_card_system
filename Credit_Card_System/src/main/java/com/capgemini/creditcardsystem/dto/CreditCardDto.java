package com.capgemini.creditcardsystem.dto;

import java.io.Serializable;

import com.capgemini.creditcardsystem.model.CardHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int creditCardId;
	private String type;
	private double joiningFees;
	private double annualFees;
	private double cardLimit;
	private String bankName;
	private CardHolder cardHolder;
}
