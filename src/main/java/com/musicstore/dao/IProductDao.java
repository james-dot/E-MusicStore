package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Product;

public interface IProductDao {

	void addProduct(Product product);
	
	void editProduct(Product product);
	
	Product getProductById(String id);
	
	List<Product> getAllProduct();
	
	void deleteProduct(String id);
}
