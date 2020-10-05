package com.lti.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.Farmer;
import com.lti.repo.FarmerRepo;

public class TestFarmer {
	
	@Autowired
	private FarmerRepo farmerrepo;
	
	@Test
	public void testAddFarmer() {
		
		Farmer farmer = new Farmer();
		farmer.setFarmerName("Anish");
		farmer.setFarmerEmail("xyz@gmial.com");
		farmer.setFarmerAddressLine1("Something");
		farmer.setFarmerAddressLine2("Anything");
		farmer.setFarmerCity("Gurgaon");
		farmer.setFarmerState("Haryana");
		farmer.setFarmerPAN("ABC1234");
		farmer.setFarmerCertificate("c:/user/something.jpg");
		farmer.setFarmerPINCode(123);
		farmer.setFarmerAADHAR("XYZ987");
		farmer.setFarmerAccountNumber(12341);
		farmer.setFarmerPassword("qwerty");
		farmer.setFarmerLandAddress("Something");
		farmer.setFarmerLandPIN("12421");
		farmer.setFarmerLandArea("gurgaon");
		
		System.out.println("Farmer added");
		
		farmerrepo.save(farmer);
	}
	
	@Test
	public void TestDelete() {
		farmerrepo.delete(1021);
		System.out.println("Farmer deleted");
	}
	
	@Test
	public void TestUpdate() {
		Farmer farmer = new Farmer();
		farmer.setFarmerId(1022);
		farmer.setFarmerName("Yojan");
		
		farmerrepo.update(farmer);
	}
	
	@Test
	public void testFetch() {
		Farmer f = farmerrepo.fetch(1022);
		System.out.println(f.getFarmerName() + "\t" + f.getFarmerState());
	}
}
