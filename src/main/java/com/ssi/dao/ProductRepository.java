package com.ssi.dao;

import java.util.List;

import com.ssi.model.Product;

public interface ProductRepository {
	public Product deleteProduct(int code);
	public Product searchProduct(int code);
	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
}
