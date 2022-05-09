package com.hof.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hof.domain.Product;
import com.hof.domain.Supplier;
import com.hof.domain.dto.CommonResponseDto;
import com.hof.domain.dto.ProductDto;
import com.hof.repository.ProductRepository;
import com.hof.util.Constants;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CommonResponseDto commonResponseDto;
	
	@Override
	public CommonResponseDto addProduct(List<Product> product)
	{
		productRepository.saveAll(product);
		commonResponseDto.setResponseCode(Constants.SUCCESS_CODE);
		commonResponseDto.setResponseMessage(Constants.PRODUCT_ADDED_SUCCESSFUL);
		return commonResponseDto;
	}
	
	public Product getSingleProduct(Integer id) {
		Product product = productRepository.findByproductId(id);	
		return product;
	}
	
	public Product setOfferToProduct(Product prod)
	{
		return productRepository.save(prod);
	}
//==================================================================//

	//1.get all product list 
	public List<ProductDto> getProductList(){
		List<ProductDto> productDtoList =  new ArrayList<>();
		List<Product> productList = productRepository.findAll();
		productList.forEach( product->{
			
			ProductDto productDto = new ProductDto();
			
				productDto.setProduct_id(product.getProductId());
				productDto.setProduct_name(product.getProductName());
				productDto.setDescription(product.getDescription());
				productDto.setPrice((float) product.getPrice());
				productDto.setQuantity(product.getQuantity());
				productDtoList.add(productDto);
			
			
		});//end of foreach loop
		
		
		return productDtoList; 
	}
	
	//2.search product 
	public Product searchProducts(Integer id) {
		Product p = productRepository.findById(id).get();
		return p;
	}
	//2.edit product		new product,old product
	public Product editProducts(Product p, Product p1) {
		p1.setProductName(p.getProductName());
		p1.setPrice(p.getPrice());
		p1.setQuantity(p.getQuantity());
		return productRepository.save(p1);
		
		
	}
	//3.soft delete
	public void softdelete(Long id) {
		
		productRepository.deleteProduct(id);
		
	}
	/*
	public Products editProducts(Products p,Products p1){
		p1.setGiftname(p.getGiftname());
		p1.setPrice(p.getPrice());
		p1.setQuantity(p.getQuantity());
		p1.setDiscountoffer(p1.getDiscountoffer());
		return productRepo.save(p1);
	}
	
	public Products searchProducts(Long id){
		Products p = productRepo.findById(id).get();
		return p;
	}
	
	
	
	public void softdelete(Long id)
	{
		 productRepo.deleteProduct(id);
	}*/
	
}
