package com.lti.test;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.repo.CropRepo;
/**
 * @author SAKSHI Java version 1.8 Test case for Crop
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestCrop {
	
	@Autowired
	private CropRepo repo;
	
	@Test
	public void testSaveCrop() {		
		Crop c1= new Crop();
		c1.setCropName("Rice");
		c1.setCropType("Rabi Crop");
		c1.setFertilizer("Ammonium Chloride");
		c1.setCropBasePrice(20000.0);
		c1.setCropSoldPrice(35000.0);
		c1.setCropQuantity(70);
		c1.setCropSoldStatus("Approved");
		c1.setSoilPH("acidic");
		
		repo.save(c1);
	}
	@Test
	public void fetchCropById() {
		Crop c1= repo.fetch(1003);
		System.out.println(c1.getCropName()+"\t"+c1.getCropType()+"\t"+c1.getCropSoldPrice());
		
	}
	@Test
	public void testListCrop() {
		List<Crop> crop= repo.list();
		for (Crop c1 : crop) {
			System.out.println(c1.getCropName()+"\t"+c1.getCropType()+"\t"+c1.getCropSoldPrice());
			
		}	
	}
	@Test
	public void testUpdateCrop() {
		Crop c1= repo.fetch(1002);
		c1.setCropBasePrice(22000.0);
		repo.update(c1);
	}
	@Test
	public void testDeleteCustomer() {
		repo.delete(1003);
		
	}

}
