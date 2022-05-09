package com.hof.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hof.domain.Category;
import com.hof.domain.Giftfor;
import com.hof.domain.Occasion;
import com.hof.domain.Product;
import com.hof.domain.dto.ProductDto;
import com.hof.repository.CategoryRepository;
import com.hof.repository.GiftForRepository;
import com.hof.repository.OccasionRepository;
import com.hof.repository.ProductRepository;



@Service
public class GiftService  implements IGiftService{
	
	@Autowired 
	CategoryRepository categoryRepository;
	
	@Autowired 
	GiftForRepository giftForRepository;
	
	@Autowired 
	OccasionRepository occasionRepository;
	
	@Autowired
	ProductRepository proRepo;
	
	

	public Giftfor getGiftFor(Integer id) {
		
		return giftForRepository.findBygiftForId(id);
	}

	public Occasion getOccasion(Integer id) {
		
		return occasionRepository.findByoccasionId(id);
	}

	public Category getCategory(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.findBycategoryId(id);
	}

	public List<ProductDto> getperfectGiftPage(Category category, Giftfor gf, Occasion oc) {
	
	List<ProductDto> productDtoList =  new ArrayList<>();
	List<Product> productList = proRepo.findByGiftforAndOccasionAndCategory(category,gf,oc);
	productList.forEach( product->{
		
		ProductDto productDto = new ProductDto();
		if(product.isVisibility())
		{
			productDto.setProduct_id(product.getProductId());
			productDto.setProduct_name(product.getProductName());
			productDto.setDescription(product.getDescription());
			productDto.setPrice((float) product.getPrice());
			productDtoList.add(productDto);
		}
		
	});
	
	return productDtoList; 
	
}
}
