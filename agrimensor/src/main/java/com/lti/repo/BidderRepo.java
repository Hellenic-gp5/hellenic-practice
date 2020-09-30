package com.lti.repo;

import java.util.List;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;


//import com.lti.entity.Friend;

public interface BidderRepo {
	
	void saveBidder(Bidder bidder);
	Bidder fetchBidderById(int bidderId);
	List<Bidder> listBidder();
	
	void deleteBidder(int bidderId);
	void updateBidder(Bidder bidder);

	
	void updateBidderStatus(int bidderId,String bidderStatus);
	
	void saveBidderCrop(Bidder bidder,int cropid);
	
	


}
