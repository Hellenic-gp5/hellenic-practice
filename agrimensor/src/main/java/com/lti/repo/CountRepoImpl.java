package com.lti.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CountRepoImpl implements CountRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Number countUsers() {
		return ((Number) em.createQuery("SELECT count(u) From User u WHERE u.status='Queued'").getSingleResult())
				.intValue();

	}

	@Override
	public Number countSoldCrop() {
		return ((Number) em.createQuery("SELECT count(c) From Crop c WHERE c.cropSoldStatus='Sold'").getSingleResult())
				.intValue();
	}

	@Override
	public Number countAllCrops() {
		return ((Number) em.createQuery("SELECT count(u) From Crop u").getSingleResult()).intValue();

	}

	@Override
	public Number countUnsoldCrop() {
		return ((Number) em.createQuery("SELECT count(c) From Crop c WHERE c.cropSoldStatus='Queued'")
				.getSingleResult()).intValue();
	}

	@Override
	public Number countRejectedInsurance() {
		return ((Number) em.createQuery("SELECT count(i) From Insurance i WHERE i.policyStatus='Rejected")
				.getSingleResult()).intValue();
	}

	@Override
	public Number countPendingInsurances() {
		return ((Number) em.createQuery("SELECT count(i) From Insurance i WHERE i.policyStatus='Pending'")
				.getSingleResult()).intValue();
	}

	@Override
	public Number countApprovedInsurances() {
		return ((Number) em.createQuery("SELECT count(i) From Insurance i WHERE i.policyStatus='Approved'")
				.getSingleResult()).intValue();
	}

	@Override
	public Number countFarmer() {
		return ((Number) em.createQuery("SELECT count(f) From Farmer f").getSingleResult()).intValue();

	}

	@Override
	public Number countBidder() {
		 return ((Number)em.createQuery("SELECT count(b) From Bidder b").getSingleResult()).intValue();
			
	}
}
