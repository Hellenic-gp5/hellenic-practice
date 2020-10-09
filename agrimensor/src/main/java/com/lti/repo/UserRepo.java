package com.lti.repo;

import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.entity.*;
/**
 * @author YOJAN
 *Java version 1.8
 *Repo for User class
 */
public interface UserRepo {
	User authenticate(Login login);
	
	void updateUserStatus(int userId, String status);
	
	void Forgotpassword(String email);

	
}
