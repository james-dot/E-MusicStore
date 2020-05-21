package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.musicstore.model.BillingAdress;
import com.musicstore.model.Customer;
import com.musicstore.model.ShippingAdress;
import com.musicstore.service.ICustomerService;

@Controller
public class RegisterController {
		
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model) {
		
		Customer customer = new Customer();
		
		//BillingAdress billingAdress; 
		//ShippingAdress shippingAdress;
		
		 customer.setBillingAddress( new BillingAdress());
		customer.setShippingAddress( new ShippingAdress());
		
		model.addAttribute("customer",customer);
		
		return "registerCustomer";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST )
	public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model) {
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
}
