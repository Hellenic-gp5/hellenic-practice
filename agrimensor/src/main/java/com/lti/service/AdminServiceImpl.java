package com.lti.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.repo.AdminRepo;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo repo;
	
	@Transactional(value = TxType.REQUIRED)
	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		repo.addAdmin(admin);
	}
	

}
