package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.User;
@Repository
public class AdminRepoImpl implements AdminRepo{

	@PersistenceContext
	private EntityManager em;
	@Transactional(value = TxType.REQUIRED)
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		em.persist(admin);
	}
	@Override
	public List<User> approval() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From User where status='Queued'");
		List<User> users= q.getResultList();
		return users;
	}

}
