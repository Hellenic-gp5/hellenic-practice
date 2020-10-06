package com.lti.repo;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.User;

public interface AdminRepo {
	void addAdmin(Admin admin);
	List<User> approval();

}
