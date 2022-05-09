package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")*/
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Integer productId;

	private String description;

	private String imagePath;

	private int price;

	private String productName;

	private int quantity;
	
	private boolean visibility;
	
	private Double offer;
	
	public Product() {
	}

	@OneToMany(mappedBy="product")
	//@JsonIgnore
	private List<OrderDetails> orderproducts;
//	@OneToMany(mappedBy="product")
//	private OrderDetails orderproducts;
	

	 @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "category_id")
	 private Category category;

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "giftfor_id")
	private Giftfor giftfor;

	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "occasion_id")
	 private Occasion occasion;
	 
	 
	
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
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

	public List<OrderDetails> getOrderproducts() {
		return this.orderproducts;
	}
	

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public void setOrderproducts(List<OrderDetails> orderproducts) {
		this.orderproducts = orderproducts;
	}

	public OrderDetails addOrderproduct(OrderDetails orderproduct) {
		getOrderproducts().add(orderproduct);
		orderproduct.setProduct(this);

		return orderproduct;
	}

	public OrderDetails removeOrderproduct(OrderDetails orderproduct) {
		getOrderproducts().remove(orderproduct);
		orderproduct.setProduct(null);

		return orderproduct;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Giftfor getGiftfor() {
		return this.giftfor;
	}

	public void setGiftfor(Giftfor giftfor) {
		this.giftfor = giftfor;
	}

	public Occasion getOccasion() {
		return this.occasion;
	}

	public void setOccasion(Occasion occasion) {
		this.occasion = occasion;
	}
	
	

	public Double getOffer() {
		return offer;
	}

	public void setOffer(Double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", imagePath=" + imagePath
				+ ", price=" + price + ", productName=" + productName + ", quantity=" + quantity + ", visibility="
				+ visibility + ", offer=" + offer + ", orderproducts=" + orderproducts + ", category=" + category
				+ ", giftfor=" + giftfor + ", occasion=" + occasion + "]";
	}

	
	
	
	

}