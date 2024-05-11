package com.osm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osm.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

	private EntityManager em;

	public UsersDaoImpl() {
		super();
	}

	@Autowired
	public UsersDaoImpl(EntityManager em) {
		this.em = em;
	}

	public boolean addUsers(Users users) {
		try {
			em.persist(users);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
