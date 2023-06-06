package com.capgemini.creditcardsystem.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cardholder")
public class CardHolder {

	@Id
	@GeneratedValue
	@Column(name = "cardNumber")
	private int cardNumber;

	@Column(name = "fromDate")
	private LocalDate fromDate;

	@Column(name = "toDate")
	private LocalDate toDate;

	@Column(name = "secretCode")
	private int secretCode;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Customer customer;

	@OneToOne(mappedBy = "cardHolder", cascade = CascadeType.ALL, orphanRemoval = true)
	private CreditCard creditCard;

	@JsonIgnore
	@OneToMany(mappedBy = "cardHolder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transaction;

}
