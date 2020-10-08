package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;
import com.lti.entity.InsuranceClaim;

/**
 * @author YOJAN java version 1.8
 *
 */
@Repository
public class InsuranceRepoImpl implements InsuranceRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	// @Override
	public void Save(Insurance ins) {
		// TODO Auto-generated method stub
		em.persist(ins);
	}

	// @Override
	public Insurance fetch(int polid) {
		// TODO Auto-generated method stub
		return em.find(Insurance.class, polid);
	}

	@Transactional(value = TxType.REQUIRED)
	// @Override
	public void update(String status, int polid) {
		// TODO Auto-generated method stub
		Insurance i = em.find(Insurance.class, polid);
		i.setPolicyStatus(status);
		em.merge(i);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void claim(int polid, InsuranceClaim claim) {
		Insurance i = em.find(Insurance.class, polid);
		i.setClaim(claim);
		em.persist(claim);
		em.merge(i);
	}

	@Override
	public List<InsuranceClaim> getClaims() {

		return em.createQuery("FROM InsuranceClaim").getResultList();
	}

}
