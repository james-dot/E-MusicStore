package com.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.ICartItemDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.service.ICartItemService;

@Service
public class CartItemServiceImpl implements ICartItemService{

	@Autowired 
	private ICartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
	
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		
		cartItemDao.removeCartItem(cartItem);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		
		cartItemDao.removeAllCartItems(cart);
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
	
		return cartItemDao.getCartItemByProductId(productId);
	}

}
