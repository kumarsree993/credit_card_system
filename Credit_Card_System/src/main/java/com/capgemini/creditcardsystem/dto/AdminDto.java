package com.capgemini.creditcardsystem.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int adminId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String mail;
	private long phoneNumber;
}
