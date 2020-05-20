package com.musicstore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicstore.model.Product;
import com.musicstore.service.IProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping //is empty by default /admin 
	public String adminPage() {
		
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping("/customer")
	public String customerManagement(Model model) {
		return "customerManagement";
	}
}
