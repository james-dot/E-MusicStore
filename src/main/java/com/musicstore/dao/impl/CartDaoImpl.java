package com.musicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.musicstore.dao.ICartDao;
import com.musicstore.model.Cart;

@Repository
public class CartDaoImpl implements ICartDao{
	
	private Map<String, Cart> listOfCarts;
	
	CartDaoImpl(){
		listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Cannot create a cart with the given id(%)"
					+ "already"
					+ "exists", cart.getCartId()));
		}
		
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not update a cart with the given id(%)"
					+ "does not"
					+ "exists", cart.getCartId()));
		}
		
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Can not delete a cart with the given id(%)"
					+ "does not"
					+ "exists", cartId));
		}
		
		listOfCarts.remove(cartId);
	}

}
