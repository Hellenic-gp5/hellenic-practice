package com.lti.service;

import java.util.List;

import com.lti.entity.Bid;

public interface BidService {
	void persistBid(Bid bid);
	
	Bid findBid(int bidId);
	
	List<Bid> loadBid();
	
	void removeBid(int bidId);
	
	void updateBid(Bid bid);
	
	void updateBidStatus(int bidId,String bidStatus);
	
	List<Bid> bidsOfBidder(int bidderId);
	
	List<Bid> getBidsOnCrop(int cropId);
	
}
