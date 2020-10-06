package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.repo.UserRepo;

/**
 * @author YOJAN
 *JAVA version 1.8
 *Service layer for User
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public User validate(Login login) {
		// TODO Auto-generated method stub
		return repo.authenticate(login);
	}

	@Override
	public void updateStatus(int userId, String status) {
		repo.updateUserStatus(userId, status);
	}

}
