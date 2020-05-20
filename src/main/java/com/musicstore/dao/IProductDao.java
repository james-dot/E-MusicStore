package com.musicstore.dao;

import java.util.List;

import com.musicstore.model.Product;

public interface IProductDao {

List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
