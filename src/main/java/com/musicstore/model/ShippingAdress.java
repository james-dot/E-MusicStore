package com.musicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingAdress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5936828308745309919L;

	@Id
	@GeneratedValue
	private int shippingAddressId;
	private String streetName;
	private String apartementNumber;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	@OneToOne
	private Customer customer;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartementNumber() {
		return apartementNumber;
	}

	public void setApartementNumber(String apartementNumber) {
		this.apartementNumber = apartementNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAdress [streetName=" + streetName + ", apartementNumber=" + apartementNumber + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	
}
