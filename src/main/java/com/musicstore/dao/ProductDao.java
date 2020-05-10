package com.musicstore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.musicstore.model.Product;

public class ProductDao {
	
	private List<Product> productList;
	
	public List<Product> getProductList(){
		Product product1 = new Product();
		product1.setProductId("P123");
		product1.setProductName("Guitar1");
		product1.setProductCategory("Instrument");
		product1.setProductDescription("This is a fender start guitar !");
		product1.setProductPrice(1200);
		product1.setProductCondition("new");
		product1.setProductStatus("Active");
		product1.setUnitInStock(11);
		product1.setProductManufacturer("fender");
		
		Product product2 = new Product();
		product2.setProductId("P124");
		product2.setProductName("Record1");
		product2.setProductCategory("Record");
		product2.setProductDescription("This is an awsome mix of 20th century !");
		product2.setProductPrice(25);
		product2.setProductCondition("new");
		product2.setProductStatus("Active");
		product2.setUnitInStock(51);
		product2.setProductManufacturer("EMI");
		
		Product product3 = new Product();
		product3.setProductId("P125");
		product3.setProductName("Speaker1");
		product3.setProductCategory("Speaker");
		product3.setProductDescription("This is a Polk Shelf Speaker !");
		product3.setProductPrice(355);
		product3.setProductCondition("new");
		product3.setProductStatus("Active");
		product3.setUnitInStock(9);
		product3.setProductManufacturer("Polk");
		
		productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
	}
	
	public Product getProductById( String productId) throws IOException {
		for(Product product: getProductList()) {
			if(product.getProductId().equals(productId)) {
				return product;
			}
		}
		throw new IOException("No product found !");
	}
	
}
