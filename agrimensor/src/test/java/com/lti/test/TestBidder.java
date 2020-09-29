package com.lti.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Bidder;
import com.lti.repo.BidderRepo;


public class TestBidder {
	
	@Autowired
	private BidderRepo repo;
	
	@Test
	public void testSaveBidder() {
		Bidder b1= new Bidder();
		b1.setBidderName("Lilly");
		b1.setBidderEmail("lilly@gmail.com");
		b1.setBidderAddressLine1("Lilly address line1");
		b1.setBidderAddressLine2("lilly address line 2");
		b1.setBidderCity("Mumbai");
		b1.setBidderState("Maharashtra");
		b1.setBidderPAN("bidder PAN");
		b1.setBidderPINCODE(2110981);
		b1.setBidderAADHAR("bidder AADHAR");
		b1.setBidderIFSC("SBI000543");
		b1.setBidderAccountNumber(123456);
		b1.setBidderPassword("lilly@123");
		b1.setBidderLicense("bidder license");
		b1.setBidderStatus("Approved");
		
		
		repo.save(b1);
	}
	@Test
	public void fetchBidderById() {
		Bidder b1= repo.fetch(1003);
		System.out.println(b1.getBidderName()+"\t"+b1.getBidderEmail()+"\t"+b1.getBidderStatus());
		
	}
	
	@Test
	public void testListBidder() {
		List<Bidder> bidder= repo.list();
		for (Bidder b1 : bidder) {
			System.out.println(b1.getBidderName()+"\t"+b1.getBidderEmail()+"\t"+b1.getBidderStatus());
			
		}	
	}
	@Test
	public void testUpdateBidder() {
		Bidder c1= repo.fetch(1001);
		c1.setBidderStatus("Waiting");
		repo.update(c1);
	}
	
	@Test
	public void testDeleteCustomer() {
		repo.delete(1004);
		
	}
	

}
