package com.lti.repo;

public interface CountRepo {
	public Number countUsers();
	
	public Number countUnsoldCrop();
	
	public Number countSoldCrop();
	
	public Number countAllCrops();

	public Number countRejectedInsurance();

	public Number countApprovedInsurances();

	public Number countPendingInsurances();
	
	public Number countFarmer();
	
	public Number countBidder();
}
