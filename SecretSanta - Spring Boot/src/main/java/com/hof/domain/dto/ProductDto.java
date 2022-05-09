package com.hof.domain.dto;

public class ProductDto {

	private Integer product_id;
	
	private String product_name;
	
	private Float price;
	
	private String description;
	
	private int quantity;
	
	private String imagePath;
	
	private double Offer;

	public double getOffer() {
		return Offer;
	}

	public void setOffer(double offer) {
		Offer = offer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	
	
}