package com.hof.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hof.domain.OrderDetails;
import com.hof.domain.Orders;

public interface OrdersDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	
	@Transactional
	@Query(value = "Select * from Orderdetails od where od.order_id = :orders", nativeQuery = true)
	List<OrderDetails> findByorder(@Param("orders") Orders orders);

}
