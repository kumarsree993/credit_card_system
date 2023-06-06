package com.capgemini.creditcardsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.creditcardsystem.model.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

	@Query("SELECT c FROM CreditCard c where c.type = :type")
	Optional<CreditCard> findByType(@Param("type") String  creditCardType);

}
