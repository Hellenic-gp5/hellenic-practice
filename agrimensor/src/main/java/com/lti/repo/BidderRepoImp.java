package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;



@Repository
public class BidderRepoImp implements BidderRepo{
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void save(Bidder bidder) {
		em.persist(bidder);
		
	}

	public Bidder fetch(int bidderId) {
		
		Bidder b=em.find(Bidder.class, bidderId);
		return b;
	}

	public List<Bidder> list() {
		return em.createQuery("from Bidder").getResultList();
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(int bidderId) {
		em.remove(em.find(Bidder.class, bidderId));	
		
	}
	@Transactional(value = TxType.REQUIRED)
	public void update(Bidder bidder) {
		em.merge(bidder);
		
	}

}
