package com.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osm.model.Cart;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	private EntityManager em;

	public CartDaoImpl() {
		super();
	}

	@Autowired
	public CartDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean addCart(Cart cart) {
		try {
			em.persist(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getallCartItem() {
		try {
			return em.createQuery("select c from Cart c").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
