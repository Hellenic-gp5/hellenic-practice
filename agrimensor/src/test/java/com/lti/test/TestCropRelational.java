package com.lti.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.repo.CropRepo;
import com.lti.repo.FarmerRepo;

/**
 * @author YOJAN Java version 1.8 Test case for Crop
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestCropRelational {
	
	  @Autowired private FarmerRepo repo;
	 
	@Autowired
	private CropRepo crepo;

	@Test
	public void addCrop() {
		Farmer farmer1 = new Farmer();
		farmer1.setFarmerId(1001);
		Crop c = new Crop();
		c.setCropName("Wheat");
		c.setCropQuantity(50);
		c.setCropSoldStatus("Bidding");
		farmer1.getCrops().add(c);
		repo.update(farmer1);
	}

	@Test
	public void editCrop() {
		Crop c = new Crop();
		c.setCropId(1001);
		c.setCropName("Rice");
		crepo.updateCrop(c);

	}
	
	@Test
	public void deleteCrop() {
		/*
		 * Farmer farmer1=repo.fetch(1001); farmer1.getCrops()
		 */
		
	}

}
