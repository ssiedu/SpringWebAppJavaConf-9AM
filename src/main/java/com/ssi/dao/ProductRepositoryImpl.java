package com.ssi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssi.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Product saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();
		return product;
	}
	
	
	public Product searchProduct(int code) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, code);
		session.close();
		return product;
	}



}