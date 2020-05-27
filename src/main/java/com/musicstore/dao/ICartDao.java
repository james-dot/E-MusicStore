package com.musicstore.dao;

import com.musicstore.model.Cart;

public interface ICartDao {

	Cart getCartById(int cartId);
	
	void update(Cart cart);
}
