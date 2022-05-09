package com.hof.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hof.domain.Orders;
import com.hof.domain.User;

public interface OrdersRepository  extends JpaRepository<Orders, Integer>{
	//@Query(value = "DELETE FROM userweight WHERE wId = ?1", nativeQuery = true)
	@Transactional
	@Query(value = "Select * from Orders o where o.user_id = :u", nativeQuery = true)
	Orders findByUser(@Param("u") User u);

}
/*@Transactional
@Query(value = "Select * from User u where u.email_address = :email and u.password = :pass",nativeQuery = true)
User findByEmailAddressAndPassword(@Param("email") String email,@Param("pass") String pass );*/