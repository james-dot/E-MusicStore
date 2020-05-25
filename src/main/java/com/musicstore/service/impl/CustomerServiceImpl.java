package com.musicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.ICustomerDao;
import com.musicstore.model.Customer;
import com.musicstore.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerByUsername(String username) {
	
		return customerDao.getCustomerByUsername(username);
	}

}
