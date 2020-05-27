package com.musicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.ICartItemDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements ICartItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session= sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems =cart.getCartItems();
		
		for(CartItem item : cartItems) {
			removeCartItem(item);
		}
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query= session.createQuery("from CartItem where productId = ?");
		query.setInteger(0, productId);
		
		session.flush();
		
		return (CartItem) query.uniqueResult();
	}

}
