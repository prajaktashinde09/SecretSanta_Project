package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	private String emailAddress;

	private String firstName;

	private String lastName;

	private int mobileNumber;

	private String password;

	//bi-directional many-to-one association to Order
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "users")
	@JsonIgnore
	private List<Orders> orders;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleId")
	private Role role;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Orders addOrder(Orders order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Orders removeOrder(Orders order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", password=" + password + ", orders=" + orders
				+ ", role=" + role + "]";
	}
	
	

}