package com.musicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.ICartDao;
import com.musicstore.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements ICartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		
		return (Cart) session.get(Cart.class, cartId);
	}

	@Override
	public void update(Cart cart) {
		
		
	}

}
