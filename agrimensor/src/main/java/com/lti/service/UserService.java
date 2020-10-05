package com.lti.service;

import com.lti.entity.User;
import com.lti.pojo.Login;

/**
 * @author YOJAN
 *JAVA VERSION 1.8
 *Service layer interface for User
 */
public interface UserService {
	User validate(Login login);
}
