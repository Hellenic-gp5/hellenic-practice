package com.lti.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.repo.BidRepo;
import com.lti.repo.BidderRepo;



/**
 * @author Sakshi
 *
 */
@Service
public class BidderServiceImp implements BidderService {

	@Autowired
	private BidderRepo repo;


	@Transactional(value = TxType.REQUIRED)
	public void persist(Bidder bidder) {
		repo.saveBidder(bidder);

	}

	public Bidder find(int bidderId) {
		return repo.fetchBidderById(bidderId);
	}

	public List<Bidder> load() {
		return repo.listBidder();
	}

	@Transactional(value = TxType.REQUIRED)
	public void remove(int bidderId) {
		repo.deleteBidder(bidderId);

	}
	@Transactional(value = TxType.REQUIRED)
	public void edit(Bidder bidder) {
		repo.updateBidder(bidder);

	}
	/**
	 * @author Sakshi
	 *methods to add crops with a particular bidder
	 */
	@Transactional(value = TxType.REQUIRED)
	public void persistBidderCrop(Bidder bidder, int cropId) {
		repo.saveBidderCrop(bidder, cropId);
		
	}

	/**
	 * @author YOJAN
	 *methods to add bid and make bid
	 */
	@Override
	public List<Bid> listBids(int bidderid) {
		// TODO Auto-generated method stub
		return repo.listOfBidsById(bidderid);
	}

	@Override
	public void makeBid(int bidderid, Bid bid, int cropid) {
		// TODO Auto-generated method stub
		repo.bid(bidderid, bid, cropid);

	}

}
