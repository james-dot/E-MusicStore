package com.musicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.IProductDao;
import com.musicstore.model.Product;
import com.musicstore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	
	@Override
	public List<Product> getProductList() {
		
		return productDao.getProductList();
	}

	@Override
	public Product getProductById(int productId) {
		
		return productDao.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		
		productDao.addProduct(product);
	}

	@Override
	public void editProduct(Product product) {
		
		productDao.editProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
		
	}

}
