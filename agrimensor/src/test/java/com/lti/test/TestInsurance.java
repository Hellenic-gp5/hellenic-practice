package com.lti.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Insurance;
import com.lti.repo.FarmerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:appctx.xml")
public class TestInsurance {
	
	@Autowired
	private FarmerRepo repo;
	
	@Test
	public void testAddInsurance() {
		
		
		Insurance insurance = new Insurance();
		
//		insurance.setPolicyNumber(10);
		//insurance.setPolicyFarmerId(20);
		insurance.setPolicyCropId(30);
		insurance.setSeason("Rabi");
		insurance.setSumPerHectare(10000);
		insurance.setPolicyCropArea(5);
		insurance.setPolicyStatus("Approved");
		insurance.setPolicyPremiumAmount(3000);
		insurance.setPolicySharedPremium(7000);
		insurance.setPolicyCompany("Bajaj");
		
		repo.addInsurance(1001, insurance);
		System.out.println("Insurance added");
	}
	
//	@Test
//	public void TestUpdate() {
//		
//		insrepo.update("Rejected", 1001);
//	}
//	
//	@Test
//	public void testFetch() {
//		Insurance ins = insrepo.fetch(1001);
//		System.out.println(ins.getPolicyId() + "\t" + ins.getPolicyCompany());
//	}
}
