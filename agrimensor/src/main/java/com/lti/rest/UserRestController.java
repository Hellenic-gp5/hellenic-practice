package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.service.UserServiceImpl;

/**
 * @author YOJAN
 *JAVA version 1.8
 */
@CrossOrigin
@RestController
public class UserRestController {
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping(value="/login",produces="application/json")
	public User signin(@RequestBody Login login) 
	{
		return service.validate(login);
	}
}