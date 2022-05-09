package com.hof.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hof.domain.Giftfor;
import com.hof.domain.Occasion;


public interface GiftForRepository extends JpaRepository<Giftfor, Integer>{
	
	public Giftfor findBygiftForId(Integer Id);
}
