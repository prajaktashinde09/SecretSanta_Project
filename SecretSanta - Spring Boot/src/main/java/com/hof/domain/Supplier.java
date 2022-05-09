package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@Table
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;

	private String categoryId;

	private String description;

	private String giftId;

	private String imagePath;

	private String occasionId;

	private float price;

	private String productName;

	private int quantity;
	
	private boolean isApproved;

	public Supplier() {
	}
	
	

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}


	public String getOccasionId() {
		return occasionId;
	}



	public void setOccasionId(String occasionId) {
		this.occasionId = occasionId;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}



	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", categoryId=" + categoryId + ", description=" + description
				+ ", giftId=" + giftId + ", imagePath=" + imagePath + ", occasionId=" + occasionId + ", price=" + price
				+ ", productName=" + productName + ", quantity=" + quantity + ", isApproved=" + isApproved + "]";
	}



	
	

}