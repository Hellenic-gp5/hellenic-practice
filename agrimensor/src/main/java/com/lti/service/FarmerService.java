package com.lti.service;

import java.util.List;

import com.lti.entity.Farmer;

public interface FarmerService {
	
void persist(Farmer farmer);
	
	Farmer find(int empid);
	
	List<Farmer> load();
	
	void remove(int farmer);
	
	void edit(Farmer farmer);
}
