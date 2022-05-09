package com.hof.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the orderproduct database table.
 * 
 */
@Entity
@Table(name="Orderdetails")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderProductId;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Orders order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProductId")
	private Product product;
//	@OneToMany
//	private List<Product> product
	
	private Integer productQuantity;

	public OrderDetails() {
	}

	public int getOrderProductId() {
		return this.orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Orders getOrder() {
		return this.order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	@Override
	public String toString() {
		return "OrderDetails [orderProductId=" + orderProductId + ", order=" + order + ", product=" + product
				+ ", productQuantity=" + productQuantity + "]";
	}

}