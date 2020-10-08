package com.lti.repo;

import java.util.ArrayList;
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
public class AdminRepoImpl implements AdminRepo {

	private CountRepo repo;
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
		Query q = em.createQuery("From User where status='Queued' AND role IN ('Farmer', 'Bidder')");
		List<User> users = q.getResultList();
		return users;
	}

	@Override
	public List<Counts> counts() {
		List<Counts> adminCounts = new ArrayList<Counts>();
		Counts count = new Counts();
		Number sold = repo.countSoldCrop();
		Number unsold = repo.countUnsoldCrop();
		Number allcrops = (Number) (sold.intValue() + unsold.intValue());
		Number pending = repo.countPendingInsurances();
		count.setAllUsers(repo.countUsers());
		count.setAllFarmers(repo.countFarmer());
		count.setAllBidders(repo.countBidder());
		count.setAllClaims(repo.countApprovedInsurances());
		count.setRejectedClaims(repo.countPendingInsurances());
		count.setSoldCrops(repo.countSoldCrop());
		count.setApprovedClaims(repo.countRejectedInsurance());
		count.setAllSellReq(allcrops);
		count.setRejectedSellReq(repo.countUnsoldCrop());
		adminCounts.add(count);
		return adminCounts;
	}

}
