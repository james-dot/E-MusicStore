package com.musicstore.dao;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

public interface ICartItemDao {

	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
