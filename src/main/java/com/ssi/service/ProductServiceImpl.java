package com.ssi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssi.dao.ProductRepository;
import com.ssi.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;


	public Product saveProduct(Product product) {
		Product pr=productRepository.saveProduct(product);
		return pr;
	}
	
	public Product productDetails(int code) {
		//fetch the product details using repository
		Product product=productRepository.searchProduct(code);
		//compute the discount
		if(product.getPrice()>=10000) {
			product.setDiscount(product.getPrice()*20/100);
		}else {
			product.setDiscount(product.getPrice()*10/100);
		}
		return product;
	}

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product deleteProduct(int code) {
		return productRepository.deleteProduct(code);
	}

}
