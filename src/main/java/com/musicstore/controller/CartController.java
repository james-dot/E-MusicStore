package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicstore.model.Customer;
import com.musicstore.service.ICustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeUser) {//Authenti... spring security generation information for that person who has login
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		
		int cartId = customer.getCart().getCartId();
		
		return "redirect:/customer/cart/"+cartId;
	}

	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value="cartId") int cartId, Model model) {
		
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
}
