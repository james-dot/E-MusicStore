package com.musicstore.service;

import com.musicstore.model.Cart;

public interface ICartService {

	Cart getCartById(int cartId);
	
	void update(Cart cart);
}
