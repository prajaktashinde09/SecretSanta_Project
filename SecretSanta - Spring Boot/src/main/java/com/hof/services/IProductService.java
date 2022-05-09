package com.hof.services;

import java.util.List;

import com.hof.domain.Product;
import com.hof.domain.dto.CommonResponseDto;

public interface IProductService {
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	CommonResponseDto addProduct(List<Product> p);

}
