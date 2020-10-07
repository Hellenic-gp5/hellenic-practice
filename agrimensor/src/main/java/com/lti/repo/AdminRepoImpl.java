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
import com.lti.entity.Bidder;
import com.lti.entity.Count;
import com.lti.entity.Farmer;
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
		Query q=em.createQuery("From User where status='Queued' AND role IN ('Farmer', 'Bidder')");
		List<User> users= q.getResultList();
		return users;
	}
	@Override
	public Count totalCount() {
		Query q1 = em.createQuery("SELECT count(u) From User u WHERE u.status=:status");
		q1.setParameter("status", "Approved");
		int totalUsers = q1.getFirstResult();
		
		Query q2 = em.createQuery("SELECT count(f) From Farmer f");
		int totalFarmer = q2.getFirstResult();
		
		Query q3 = em.createQuery("SELECT count(b) From Bidder b");
		int totalBidder = q3.getFirstResult();
		
		Count c = new Count(totalUsers,totalFarmer,totalBidder);
		
		System.out.println(totalUsers+totalFarmer+totalBidder);
		
		return c;
	}

}
