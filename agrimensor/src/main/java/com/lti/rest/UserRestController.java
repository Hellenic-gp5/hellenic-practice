package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value="/login",produces="application/json")
	public User signin(@RequestParam("username")String username, @RequestParam("password")String password,
			@RequestParam("role")String role) 
	{
		Login login=new Login(username,password,role);
		return service.validate(login);
	}
	//for admin
	@GetMapping(value = "/userstatus")
	public String updateUserStatus(@RequestParam String userStatus, @RequestParam int userId) {
		service.updateStatus(userId, userStatus);
		return "Status changed successfully to " + userStatus;
	}
}
