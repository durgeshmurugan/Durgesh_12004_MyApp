package com.osm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osm.dao.ProductDaoImpl;
import com.osm.model.Product;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductController {

	@Autowired
	ProductDaoImpl productDAO;

	public ProductController(ProductDaoImpl productDAO) {
		this.productDAO = productDAO;
	}

	@PostMapping("/add-product")
	public String doInsert(@RequestBody Product product) {
		String str = "";
		try {
			productDAO.addProduct(product);
			str = "Data Saved Successfully";
		} catch (Exception e) {
			str = "Data Failure";
		}

		return str;
	}

	@GetMapping("/get-all-product")
	List<Product> viewAll() {
		return productDAO.getallProduct();
	}

	@PutMapping("/update-product/{productId}")
	public Product doUpdate(@RequestBody Product product, @PathVariable int productId) {
		product.setProductId(productId);
		return productDAO.updateProduct(product);
	}

	@GetMapping("get-product/{productId}")
	public Product goGetId(@PathVariable int productId) {
		return productDAO.getProductById(productId);
	}

}
