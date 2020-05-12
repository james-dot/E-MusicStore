package com.musicstore.dao.impl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.musicstore.dao.IProductDao;
import com.musicstore.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}

	@Override
	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}

}
