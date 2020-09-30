package com.lti.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.repo.BidderRepo;
import com.lti.repo.CropRepo;
import com.lti.repo.CropRepoImp;

/**
 * @author SAKSHI Java version 1.8 Test case for Bidder-Crop Relation
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestBidderCrop {
	
	@Autowired
	private BidderRepo repo;
	
	//@Autowired
	//private CropRepo repo1;
	
	
	@Test
	public void testAddBidderCrop() {
	Bidder b1= repo.fetchBidderById(1001);
	repo.saveBidderCrop(b1, 1004);
	
	}
	
	@Test
	public void fetchCropByBidder() {
		Bidder b1=repo.fetchBidderById(1001);
		Set<Crop> crop = b1.getCrop();
		   for (Crop c : crop) {
			   System.out.println(c.getCropId()+" \t "+c.getCropName());
			
		}
	}
	
	
	
	
	
	
	

}
