package com.musicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.ICustomerDao;
import com.musicstore.model.Authorities;
import com.musicstore.model.Cart;
import com.musicstore.model.Customer;
import com.musicstore.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		
		Session session= sessionFactory.getCurrentSession();
		
		//relation with BillingAdress and ShippingAdress
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);//generat by system
		
		session.saveOrUpdate(customer.getBillingAddress());//persist BillingAdress
		session.saveOrUpdate(customer.getShippingAddress());//persist ShippingAdress
		//persist User
		Users newUser = new Users();
		
		newUser.setUsername(customer.getCustomerName());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		newUser.setCustomerId(customer.getCustomerId());
		
		//persist Authority
		Authorities newAuthority = new Authorities();
		
		newAuthority.setUsername(customer.getUsername());
		newAuthority.setAuthority("ROLE_USER");
				
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		
		//persist Cart
		Cart newCart = new Cart();
		
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(customer);//persist again
		session.saveOrUpdate(newCart);
						
		session.flush();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Customer) session.get(Customer.class, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		return customerList;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0, username);
		return (Customer) query.uniqueResult();
	}

}
