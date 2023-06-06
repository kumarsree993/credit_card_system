package com.capgemini.creditcardsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "creditcard")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditCardId") 
	private int creditCardId;
	
	@Column(name = "type") 
	private String type;
	
	@Column(name = "joiningFees")
	private double joiningFees;
	
	@Column(name = "annualFees")
	private double annualFees;
	
	@Column(name = "cardLimit")
	private double cardLimit;
	
	@Column(name = "bankName")
	private String bankName;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CardHolder cardHolder;

}
