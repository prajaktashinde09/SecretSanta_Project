package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the giftfor database table.
 * 
 */
@Entity
@Table
public class Giftfor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "giftfor_id")
	private int giftForId;

	private String giftForWhom;

	//bi-directional many-to-one association to Product


	@OneToMany(/*cascade = CascadeType.ALL,fetch = FetchType.EAGER,*/ mappedBy = "giftfor")
	@JsonIgnore
	private List<Product> products;

	public Giftfor() {
	}

	public int getGiftForId() {
		return this.giftForId;
	}

	public void setGiftForId(int giftForId) {
		this.giftForId = giftForId;
	}

	public String getGiftForWhom() {
		return this.giftForWhom;
	}

	public void setGiftForWhom(String giftForWhom) {
		this.giftForWhom = giftForWhom;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setGiftfor(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setGiftfor(null);

		return product;
	}

	@Override
	public String toString() {
		return "Giftfor [giftForId=" + giftForId + ", giftForWhom=" + giftForWhom + "]";
	}
	

}