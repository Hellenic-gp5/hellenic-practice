package com.lti.repo;

import java.util.List;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.entity.Crop;

public interface BidderRepo {
	
	void saveBidder(Bidder bidder);
	
	Bidder fetchBidderById(int bidderId);
	
	List<Bidder> listBidder();
	
	void deleteBidder(int bidderId);
	
	void updateBidder(Bidder bidder);

	void updateBidderStatus(int bidderId,String bidderStatus);
	
	void saveBidderCrop(Bidder bidder,int cropid);
	
	List<Bid> listOfBidsById(Bidder id);


}
