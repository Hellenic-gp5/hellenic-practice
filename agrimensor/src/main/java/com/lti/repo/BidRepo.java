package com.lti.repo;

import java.util.List;

import com.lti.entity.Bid;

public interface BidRepo {
	void saveBid(Bid bid);

	Bid fetchBid(int bidId);

	List<Bid> listOfBids();

	void deleteBid(int bidId);

	void updateBid(Bid bid);

	List<Bid> listOfRejectedBids(String Status);

	List<Bid> listOfApprovedBids(String Status);

	List<Bid> listOfBidsOfBidder(int bidderId);

	List<Bid> listOfBidsByCrop(int cropId);

	Bid fetchCurrentBid(int cropId);
}
