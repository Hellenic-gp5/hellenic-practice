package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;



@Repository
public class BidderRepoImp implements BidderRepo{
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void saveBidder(Bidder bidder) {
		em.persist(bidder);
		
	}

	public Bidder fetchBidderById(int bidderId) {
		
		Bidder b=em.find(Bidder.class, bidderId);
		return b;
	}

	public List<Bidder> listBidder() {
		return em.createQuery("from Bidder").getResultList();
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteBidder(int bidderId) {
		em.remove(em.find(Bidder.class, bidderId));	
		
	}
	@Transactional(value = TxType.REQUIRED)
	public void updateBidder(Bidder bidder) {
		em.merge(bidder);
		
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void updateBidderStatus(int bidderId, String bidderStatus) {
		em.createQuery("UPDATE Bidder b SET b.bidderStatus= :bidderStatus " + "WHERE b.bidderId = :bidderId");
		
		
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void saveBidderCrop(Bidder bidder, int cropId) {
		Crop c=em.find(Crop.class, cropId);
		bidder.getCrop().add(c);
		
		em.merge(bidder);
		
	}
	

	

}
