package com.hof.domain.dto;

public class Cart {

	String productName;
	int quantity;
	float price;
	double offer;
	String image;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	} 
	
	
}
