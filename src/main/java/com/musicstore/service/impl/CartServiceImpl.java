package com.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.ICartDao;
import com.musicstore.model.Cart;
import com.musicstore.service.ICartService;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private ICartDao cartDao;
	
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		
		cartDao.update(cart);
	}

}
