package com.hof.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hof.domain.Category;
import com.hof.domain.Giftfor;
import com.hof.domain.Occasion;
import com.hof.domain.Product;
import com.hof.domain.Supplier;
import com.hof.domain.dto.ProductDto;
import com.hof.services.CartService;
import com.hof.services.GiftService;
import com.hof.services.ProductService;
import com.hof.services.UserService;

@RestController
public class GiftController {
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	UserService uservice;
	
	@Autowired 
	CartService cartService;
	
	@Autowired
	GiftService giftService;
	
	//all gift list page 
	@GetMapping("/giftListPage")
	public List<ProductDto> getAllProductList()
	{
		return uservice.getAllProductList();
	}
	
	
	//finding perfect gift page
	@PostMapping("/perfectGiftPage")
	public List<ProductDto> getperfectGiftPage(@RequestBody String sid)
	{
		List<Integer> numlist=new ArrayList();//number list
		 
		//convert string array into integer
		System.out.println("sid: "+sid);
		String strNew = sid.substring(1, sid.length()-1);
		String array1[]= strNew.split(",");	
		for (String temp: array1){
		      System.out.println(temp);
		      numlist.add(Integer.parseInt(temp));  
		}
		
		Giftfor gf = giftService.getGiftFor(numlist.get(0)); 
		Occasion oc = giftService.getOccasion(numlist.get(1));
		Category category = giftService.getCategory(numlist.get(2));
		
		List<ProductDto> productDtoList = giftService.getperfectGiftPage(category,gf,oc);
		return productDtoList;
		
	}

	
	
	

}
