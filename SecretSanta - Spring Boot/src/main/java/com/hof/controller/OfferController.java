package com.hof.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hof.domain.Product;
import com.hof.domain.dto.ProductDto;
import com.hof.services.CartService;
import com.hof.services.ProductService;
import com.hof.services.UserService;

@RestController
public class OfferController {
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	UserService uservice;
	
	@Autowired 
	CartService cartService;
	
	
	//get list of products for adding offer
		@GetMapping("/giftListOffer")
		public List<ProductDto> getAllProductList()
		{
			return uservice.getAllProductList();
		}
		
//adding offer to the multiple products 
	
	@PostMapping("/addOffer")
	public String addOffer(@RequestBody String sid)
	{
		List<Integer> numlist=new ArrayList();
		List<Product> prodlist=new ArrayList(); 
		
		System.out.println("sid: "+sid);
		String strNew = sid.substring(1, sid.length()-1);
		
		String array1[]= strNew.split(",");
		
		for (String temp: array1){
		      System.out.println(temp);
		      numlist.add(Integer.parseInt(temp));  
		}
		
		 int last = numlist.get(numlist.size() - 1);
		 double offer = last;
		 numlist.remove(numlist.size() - 1);
		 System.out.println("last index is removed ");
		 for(int num:numlist)
			{
				
				System.out.println("After last index is removed : "+num);	
				
			}
		
		for(int num:numlist)
		{
			Product product= this.cartService.getSingleProductData(num);
			System.out.println("product  in offer controller ==== "+product.getProductName());
			product.setOffer(offer);
			prodlist.add(product);
			productService.setOfferToProduct(product);
				
			
		}
		
		
		return "successful";
	}
	
	
	// offer page :=  gift list with offer
	@GetMapping("/OfferPage")
	public List<ProductDto> getOfferPage()
	{
		return uservice.getOfferPage();
	}
	
	

}
