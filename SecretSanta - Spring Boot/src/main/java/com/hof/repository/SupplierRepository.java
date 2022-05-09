package com.hof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hof.domain.Supplier;


@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
	
	public Supplier findBysupplierId(int id);
 
}