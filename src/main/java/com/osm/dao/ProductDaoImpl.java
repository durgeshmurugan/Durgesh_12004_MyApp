package com.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osm.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	private EntityManager em;

	public ProductDaoImpl() {
		super();
	}

	@Autowired
	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			em.persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getallProduct() {
		try {
			return em.createQuery("select p from Product p").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public Product getProductById(int productId) {
		try {
			return em.find(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Product();
	}

	@Override
	public Product updateProduct(Product product) {
		try {
			return em.merge(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
