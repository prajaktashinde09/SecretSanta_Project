package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the occasion database table.
 * 
 */
@Entity
@Table
public class Occasion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "occasion_id")
	private int occasionId;

	private String occasionName;

	//bi-directional many-to-one association to Product
	@OneToMany(/*cascade = CascadeType.ALL,fetch = FetchType.EAGER,*/ mappedBy = "occasion")
	@JsonIgnore
	private List<Product> products;

	public Occasion() {
	}

	public int getOccasionId() {
		return this.occasionId;
	}

	public void setOccasionId(int occasionId) {
		this.occasionId = occasionId;
	}

	public String getOccasionName() {
		return this.occasionName;
	}

	public void setOccasionName(String occasionName) {
		this.occasionName = occasionName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setOccasion(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setOccasion(null);

		return product;
	}

	@Override
	public String toString() {
		return "Occasion [occasionId=" + occasionId + ", occasionName=" + occasionName + "]";
	}

}