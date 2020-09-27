package com.lti.repo;

import java.util.List;

import com.lti.entity.Bidder;


//import com.lti.entity.Friend;

public interface BidderRepo {
	
	void save(Bidder bidder);
	Bidder fetch(int bidderId);
	List<Bidder> list();
	
	void delete(int bidderId);
	void update(Bidder bidder);
	


}
