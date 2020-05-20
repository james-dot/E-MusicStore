package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Product;

public interface IProductService {

	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
