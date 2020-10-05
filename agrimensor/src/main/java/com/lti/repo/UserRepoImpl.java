package com.lti.repo;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;
import com.lti.pojo.Login;

/**
 * @author YOJAN
 *Java version 1.8
 *Implementation of User repo
 */
@Repository
public class UserRepoImpl implements UserRepo {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public User authenticate(Login login) {
		// TODO Auto-generated method stub
		Encoder encode= Base64.getEncoder();
		Query query= em.createQuery("FROM User WHERE emailId=:uname AND password=:pwd AND role=:rol");
		query.setParameter("uname", login.getUsername());
		query.setParameter("pwd",encode.encodeToString(login.getPassword().getBytes()));
		query.setParameter("rol", login.getRole());
		return (User) query.getSingleResult();
	}

}
