package com.lti.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.repo.BidRepo;
import com.lti.repo.BidderRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestBidBidder {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private BidderRepo brepo;
	@Autowired
	private BidRepo repo;

	@Test
	public void testSaveBidder() {
		Bidder b1 = new Bidder();
		b1.setBidderName("LOhn");
		b1.setBidderEmail("lohn@gmail.com");
		b1.setBidderAddressLine1("Lohn address line1");
		b1.setBidderAddressLine2("lohn address line 2");
		b1.setBidderCity("Mumbai");
		b1.setBidderState("Maharashtra");
		b1.setBidderPAN("bidder PAN");
		b1.setBidderPINCODE(2110981);
		b1.setBidderAADHAR("bidder AADHAR");
		b1.setBidderIFSC("SBI12333");
		b1.setBidderAccountNumber(123456);
		b1.setBidderPassword("lohn@123");
		b1.setBidderLicense("bidder license");
		b1.setBidderStatus("Approved");
		brepo.saveBidder(b1);
	}

	@Test
	public void testAddBid() {
		Bid b1 = new Bid();
		Crop c1= em.find(Crop.class, 1001);
		b1.setCropId(c1);
		b1.setBidAmount(3000.0);
		b1.setBidStatus("Queued");
		Bidder b2 = em.find(Bidder.class, 1002);
		b1.setBidderId(b2);
		repo.saveBid(b1);
	}
	@Test
	public void getBidsByBidder() {
		Bidder bidder = em.find(Bidder.class, 1001);
		List<Bid> b = brepo.listOfBidsById(bidder);
		for (Bid bid : b) {
			System.out.println(bid.getBidder().getBidderId()+ " "+bid.getBidStatus());
		}
		}
	

}
