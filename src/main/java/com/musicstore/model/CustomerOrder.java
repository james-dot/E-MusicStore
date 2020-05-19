package com.musicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 281957676248251577L;

	@Id
	@GeneratedValue
	private int customerOrderId;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	 
	@OneToOne
	@JoinColumn(name= "billingAddressId")
	private BillingAdress billingAddress;
	
	@OneToOne
	@JoinColumn(name= "shippingAddressId")
	private ShippingAdress shippingAddress;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAdress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAdress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAdress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAdress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	
}
