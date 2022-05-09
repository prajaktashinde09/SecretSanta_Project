package com.hof.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hof.domain.Category;
import com.hof.domain.Occasion;

public interface OccasionRepository extends JpaRepository<Occasion, Integer> {
	
	public Occasion findByoccasionId(Integer Id);

}
