package com.lti.repo;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lti.entity.Bid;

@Repository
public class BidRepoImpl implements BidRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void saveBid(Bid bid) {
		em.persist(bid);

	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteBid(int bidId) {
		// TODO Auto-generated method stub
		em.remove(em.find(Bid.class, bidId));

	}

	@Transactional(value = TxType.REQUIRED)
	public void updateBid(Bid bid) {
		// TODO Auto-generated method stub
		em.merge(bid);
	}

	public List<Bid> listOfBids() {
		// TODO Auto-generated method stub
		return (List<Bid>) em.createQuery("FROM Bid").getResultList();
	}

	public Bid fetchBid(int bidId) {
		// TODO Auto-generated method stub
		return em.find(Bid.class, bidId);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateBidStatus(int bidId, String bidStatus) {
		// TODO Auto-generated method stub
		Bid b1 = em.find(Bid.class, bidId);
		b1.setBidStatus(bidStatus);
	}
	
	public List<Bid> listOfRejectedBids(String Status) {
		Query q1 = em.createNamedQuery("getBidStatus");
		q1.setParameter("crl", "Rejected");
		return q1.getResultList();
	}

	public List<Bid> listOfApprovedBids(String Status) {
		Query q1 = em.createNamedQuery("getBidStatus");
		q1.setParameter("crl", "Approved");
		return q1.getResultList();
	}

}
