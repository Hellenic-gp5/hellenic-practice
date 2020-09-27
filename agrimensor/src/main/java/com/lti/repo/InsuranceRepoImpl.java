package com.lti.repo;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;

/**
 * @author YOJAN java version 1.8
 *
 */
@Repository
public class InsuranceRepoImpl implements InsuranceRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void Save(Insurance ins) {
		// TODO Auto-generated method stub
		em.persist(ins);
	}

	@Override
	public Insurance fetch(int polid) {
		// TODO Auto-generated method stub
		return em.find(Insurance.class, polid);
	}

	@Override
	public List<Insurance> list() {
		// TODO Auto-generated method stub
		return (List<Insurance>) em.createQuery("From Insurance").getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void update(String status, int polid) {
		// TODO Auto-generated method stub
		em.find(Insurance.class, polid).setPolicyStatus(status);

	}

}
