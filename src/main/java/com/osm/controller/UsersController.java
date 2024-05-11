package com.osm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osm.dao.UsersDaoImpl;
import com.osm.model.Users;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
	
	@Autowired
	UsersDaoImpl usersDAO;

	@PostMapping("/add-users")
	public String doInsert(@RequestBody Users users) {
		String str = "";
		try {
			usersDAO.addUsers(users);
			str = "Data Saved Successfully";
		} catch (Exception e) {
			str = "Data Failure";
		}

		return str;
	}

}
