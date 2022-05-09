package com.hof.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hof.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
