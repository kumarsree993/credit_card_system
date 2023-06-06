package com.capgemini.creditcardsystem;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreditCardSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardSystemApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
	    modelMapper.getConfiguration()
	        .setMatchingStrategy(MatchingStrategies.STRICT);
	    return modelMapper;
	}

}
