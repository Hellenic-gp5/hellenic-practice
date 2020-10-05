package com.lti.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Crop;
import com.lti.repo.FarmerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:appctx.xml")
public class TestFarmerCrop {
	
	@Autowired
	private FarmerRepo repo;
	
	@Test
	public void testAddCrop() {		
		Crop c= new Crop();
		c.setCropName("Rice");
		c.setCropType("Rabi Crop");
		c.setFertilizer("Ammonium Chloride");
		c.setCropBasePrice(20000.0);
		c.setCropSoldPrice(35000.0);
		c.setCropQuantity(70);
		c.setCropSoldStatus("Approved");
		c.setSoilPH("acidic");
		
		repo.addCrop(1027,c);
		System.out.println("Crop added successfully");
	}

}
