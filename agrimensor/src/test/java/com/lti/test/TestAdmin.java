package com.lti.test;

import org.junit.Test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.repo.BidRepo;
import com.lti.repo.BidderRepo;

/**
 * @author Ruhi
 * @version 1.8 Test for admin entity. This class is for updating the statuses
 *          for bids and the user.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestAdmin {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private BidRepo bidRepo;
	@Autowired
	private BidderRepo bidderRepo;

	// test for updating the Bid status
	@Test
	public void updateBidStat() {
		bidRepo.updateBidStatus(1010, "rejected");
	}

	// test to get all the approved bids
	@Test
	public void getApprovedBids() {
		List<Bid> b = bidRepo.listOfApprovedBids("Approved");
		for (Bid bid : b) {
			System.out.println(bid.getBidder().getBidderId() + " " + bid.getBidStatus());
		}
	}

	/* test to get all the Rejected Bids */

	@Test
	public void getRejectedBids() {
		List<Bid> b = bidRepo.listOfRejectedBids("Rejected");
		for (Bid bid : b) {
			System.out.println(bid.getBidder().getBidderId() + " " + bid.getBidStatus());
		}
	}
}
