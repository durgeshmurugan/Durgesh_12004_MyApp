package com.osm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osm.dao.CartDaoImpl;
import com.osm.model.Cart;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CartController {

	@Autowired
	CartDaoImpl cartDAO;

	public CartController(CartDaoImpl cartDAO) {
		this.cartDAO = cartDAO;
	}

	@PostMapping("/add-cart")
	public String doInsert(@RequestBody Cart cart) {
		String str = "";
		try {
			cartDAO.addCart(cart);
			str = "Data Saved Successfully";
		} catch (Exception e) {
			str = "Data Failure";
		}

		return str;
	}

	@GetMapping("/get-all-items")
	List<Cart> viewAll() {
		return cartDAO.getallCartItem();
	}

}
