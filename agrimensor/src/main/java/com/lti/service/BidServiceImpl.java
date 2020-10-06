package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bid;
import com.lti.repo.BidRepo;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepo repo;

	@Transactional(value = TxType.REQUIRED)
	public void persistBid(Bid bid) {
		// TODO Auto-generated method stub

		repo.saveBid(bid);
	}

	public Bid findBid(int bidId) {
		return repo.fetchBid(bidId);
	}

	public List<Bid> loadBid() {
		return repo.listOfBids();
	}

	@Transactional(value = TxType.REQUIRED)
	public void removeBid(int bidId) {
		repo.deleteBid(bidId);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateBid(Bid bid) {
		repo.updateBid(bid);
	}


	public List<Bid> bidsOfBidder(int id) {
		return repo.listOfBidsOfBidder(id);
	}

	@Override
	public List<Bid> getBidsOnCrop(int cropId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBidStatus(int bidId, String bidStatus) {
		// TODO Auto-generated method stub
		
	}
}
