package com.capgemini.creditcardsystem.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue
	@Column(name = "transactionId")
	private int transactionId;

	@Column(name = "transactionDate")
	private LocalDate transactionDate;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private double amount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private CardHolder cardHolder;

}
