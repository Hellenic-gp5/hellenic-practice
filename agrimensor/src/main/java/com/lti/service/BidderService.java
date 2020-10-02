package com.lti.service;

import java.util.List;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;


public interface BidderService {
	
	void persist(Bidder bidder);
	
	Bidder find(int bidderId);
	
	List<Bidder> load();
	
	void remove(int bidderId);
	
	void edit(Bidder bidder);
	
	List<Bid> listBids(int bidderid);
	
	void makeBid(int bidderid, Bid bid, int cropid);

}
