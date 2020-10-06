package com.lti.service;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Count;
import com.lti.entity.User;

public interface AdminService {

	void createAdmin(Admin admin );
	List<User> approvals();
	Count totalCount();
}
