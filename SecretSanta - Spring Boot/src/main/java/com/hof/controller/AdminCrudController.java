package com.hof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hof.domain.Product;
import com.hof.domain.dto.ProductDto;
import com.hof.services.ProductService;

@RestController
public class AdminCrudController {
	
	@Autowired 
	ProductService productService;
	
	@GetMapping("/productList")
	public List<ProductDto> productList()
	{
		//get all product list with visibiltity=0 and visibiltity=1
		return productService.getProductList();
	}
	
	@PostMapping("/editproduct/{id}")
	public Product productList(@PathVariable Integer id,@RequestBody Product p){
		Product p1 = productService.searchProducts(id);
		productService.editProducts(p, p1);
		return p1;
		}
	
	@PutMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id){
		productService.softdelete(id);
	
	}
	
	
	

}
