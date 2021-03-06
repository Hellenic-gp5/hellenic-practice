package com.lti.service;

import java.util.List;

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.repo.Policies;

public interface FarmerService {
	
void persist(Farmer farmer);
	
	Farmer find(int empid);
	
	List<Farmer> load();
	
	void remove(int farmer);
	
	void edit(Farmer farmer);
	
	void insure(int fid, Insurance insurance);
	
	void Add(int farmerId,Crop crop);
	
	/* void updateFarmerStatus(String farmerStatus, int farmerId); */
	
	//Number countFarmer();
	
	List<Policies> policies(int farmerid);
}
