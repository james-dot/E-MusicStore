package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Customer;

public interface ICustomerDao {

    void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
}
