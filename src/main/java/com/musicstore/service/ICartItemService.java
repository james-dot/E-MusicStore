package com.musicstore.service;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

public interface ICartItemService {

	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
