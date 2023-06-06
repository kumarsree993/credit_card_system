package com.capgemini.creditcardsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.creditcardsystem.model.CardHolder;

public interface CardHolderRepository extends JpaRepository<CardHolder, Integer>{

}
