package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")

public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;

	
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	private float totalAmount;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	//@JsonIgnore
	private User users;
	
	
	//bi-directional many-to-one association to Orderproduct
	@OneToMany(mappedBy="order")
	@JsonIgnore
	private List<OrderDetails> orderproducts;

	public Orders() {
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderDetails> getOrderproducts() {
		return this.orderproducts;
	}

	public void setOrderproducts(List<OrderDetails> orderproducts) {
		this.orderproducts = orderproducts;
	}
	
	public User getUser() {
		return this.users;
	}

	public void setUser(User user) {
		this.users = user;
	}

	
	//convients methods for adding products;
	public OrderDetails addOrderproduct(OrderDetails orderproduct) {
		getOrderproducts().add(orderproduct);
		orderproduct.setOrder(this);
		return orderproduct;
	}

	//convients methods for removing products
	public OrderDetails removeOrderproduct(OrderDetails orderproduct) {
		getOrderproducts().remove(orderproduct);
		orderproduct.setOrder(null);
		return orderproduct;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + "]";
	}

	
	
	

}