package com.lti.test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import com.lti.repo.CropRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestCropBid {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private BidderRepo brepo;
	@Autowired
	private BidRepo repo;
	@Autowired
	private CropRepo crepo;
	
	@Test
	public void testAddBidsOnCrops(){
		Bid b1 = new Bid();
		Crop c1= em.find(Crop.class, 1001);
		b1.setCropId(c1);
		b1.setBidAmount(3000.0);
		b1.setBidStatus("Queued");
		Bidder b2 = em.find(Bidder.class, 1003);
		b1.setBidderId(b2);
		repo.saveBid(b1);
	}
	@Test
	public void getBidsByCropId() {
		
			Crop crop = em.find(Crop.class, 1001);
			List<Bid> b = crepo.listOfBidsByCropId(crop);
			for (Bid bid : b) {
				System.out.println(bid.getBidStatus()+ " "+bid.getCropId().getCropId()+" "+bid.getBidId());
			}
			}
	}
	
