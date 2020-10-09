package com.lti.repo;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.mail.*;
/**
 * @author YOJAN Java version 1.8 Implementation of User repo
 */
@Repository
public class UserRepoImpl implements UserRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User authenticate(Login login) {
		// TODO Auto-generated method stub
		Encoder encode = Base64.getEncoder();
		Query query = em
				.createQuery("FROM User WHERE emailId=:uname AND password=:pwd AND role=:rol AND status='Approved'");
		query.setParameter("uname", login.getUsername());
		query.setParameter("pwd", encode.encodeToString(login.getPassword().getBytes()));
		query.setParameter("rol", login.getRole());
		return (User) query.getSingleResult();
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void updateUserStatus(int userId, String status) {
		User user = em.find(User.class, userId);
		if (status.equalsIgnoreCase("Approved")) {
			user.setStatus(status);

			em.merge(user);
			SendEmail.SendMail(user.getEmailId(),user.getPassword(),user.getName(), user.getRole());
		} else {
			em.remove(user);
		}

	}

	@Override
	public void Forgotpassword(String email) {
		// TODO Auto-generated method stub
		Query q=em.createNativeQuery("Select user_id from users where emailId=:email");
		q.setParameter("email", email);
		int userid=(int) q.getSingleResult();
		User user=em.find(User.class, userid);
		SendEmail.ForgotPassword(user.getEmailId(), user.getPassword(), user.getRole());
		
	}

}
