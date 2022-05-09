package com.hof.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hof.domain.Supplier;
import com.hof.repository.SupplierRepository;
/**
 * @author Administrator
 * 1. Uploading excel sheet product details  data to database
 * 2. Get all products details for approving
 *
 */
@Service
public class SupplierService {
	@Autowired
	SupplierRepository supRepo;

	public String addSupplierFileData(List<Supplier> s) {
		
		supRepo.saveAll(s);
		return "successfully added";
		
	}

	public List<Supplier> getList() {
	
		return (List<Supplier>) supRepo.findAll();
	}

	public Supplier getSingleSupplier(int id) {
		Supplier s = supRepo.findBysupplierId(id);	
		return s;
	}

	public void updateApprovedList(List<Supplier> approvedList) {
		
		supRepo.saveAll(approvedList);
	}
	

}
