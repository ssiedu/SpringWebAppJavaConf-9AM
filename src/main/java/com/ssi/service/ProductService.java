package com.ssi.service;

import java.util.List;

import com.ssi.model.Product;

public interface ProductService {
	public Product deleteProduct(int code);
	public Product productDetails(int code);
	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
}
