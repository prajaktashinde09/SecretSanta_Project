package com.hof.repository;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hof.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findById(Integer id);
	
	@Transactional
	@Query(value = "Select * from User u where u.email_address = :email and u.password = :pass",nativeQuery = true)
	User findByEmailAddressAndPassword(@Param("email") String email,@Param("pass") String pass );
	
	
	
	//public User finbById(Integer id);

}
