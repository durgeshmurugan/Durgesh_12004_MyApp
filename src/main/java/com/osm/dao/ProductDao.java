package com.osm.dao;

import java.util.List;

import com.osm.model.Product;

public interface ProductDao {

	boolean addProduct(Product product);

	List<Product> getallProduct();

	public Product getProductById(int productId);

	public Product updateProduct(Product product);

}
