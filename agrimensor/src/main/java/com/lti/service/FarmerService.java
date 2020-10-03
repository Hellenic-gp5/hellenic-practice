package com.lti.service;

import java.util.List;

import com.lti.entity.Farmer;
import com.lti.entity.Insurance;

public interface FarmerService {
	
void persist(Farmer farmer);
	
	Farmer find(int empid);
	
	List<Farmer> load();
	
	void remove(int farmer);
	
	void edit(Farmer farmer);
	
	void insure(int fid, Insurance insurance);
}
