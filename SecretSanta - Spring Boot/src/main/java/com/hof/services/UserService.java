package com.hof.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hof.domain.Feedback;
import com.hof.domain.Product;
import com.hof.domain.User;
import com.hof.domain.dto.ProductDto;
import com.hof.repository.FeedbackRepository;
import com.hof.repository.ProductRepository;
import com.hof.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	ProductRepository proRepo;
	

	@Autowired
	FeedbackRepository feedRepo;
	
	public User userReg(User u)
	{
		
		return userRepo.save(u);
	}
	
	public User validate(String email, String pass) {
		//System.out.println("in user service "+userRepo.findByEmailAddressAndPassword(email, pass));
		return userRepo.findByEmailAddressAndPassword(email, pass);
	}


	public List<ProductDto> getAllProductList() {
		
		List<ProductDto> productDtoList =  new ArrayList<>();
		List<Product> productList = proRepo.findAll();
		productList.forEach( product->{
			
			ProductDto productDto = new ProductDto();
			if(product.isVisibility())
			{
				productDto.setProduct_id(product.getProductId());
				productDto.setProduct_name(product.getProductName());
				productDto.setDescription(product.getDescription());
				productDto.setPrice((float) product.getPrice());
			    productDto.setImagePath(product.getImagePath());
				productDtoList.add(productDto);
			}
		});
		return productDtoList; 
		
	}
	
	public  List<ProductDto> getOfferPage()
	{
		
		List<ProductDto> productDtoList =  new ArrayList<>();
		List<Product> productList = proRepo.findAll();
		productList.forEach( product->{
			
			ProductDto productDto = new ProductDto();
			if(product.isVisibility() && ( product.getOffer()!= null))
			{
				productDto.setProduct_id(product.getProductId());
				productDto.setProduct_name(product.getProductName());
				productDto.setDescription(product.getDescription());
				productDto.setPrice((float) product.getPrice());
				productDto.setImagePath(product.getImagePath());
				productDto.setOffer(product.getOffer());
				productDtoList.add(productDto);
			}
			
			
		});
		return productDtoList; 
		
	}

	public Feedback addFeedBack(Feedback f)
	{
		feedRepo.save(f);
		return f;
	}
	
	

}
