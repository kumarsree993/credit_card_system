package com.capgemini.creditcardsystem.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.creditcardsystem.model.CardHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDto {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String mail;
	private long phoneNumber;
	private String city;
	private String state;
	private long pinCode;
	private String userName;
	private String password;
	private double income;
	private String gender;
	private LocalDate dob;
	private Set<CardHolder> cardHolder = new HashSet<>();

}
