package com.osm.dao;

import java.util.List;

import com.osm.model.Cart;

public interface CartDao {
	
	boolean addCart(Cart cart);

	List<Cart> getallCartItem();



}
