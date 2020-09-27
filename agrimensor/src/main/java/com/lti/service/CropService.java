package com.lti.service;

import java.util.List;

import com.lti.entity.Crop;

public interface CropService {
	
void persist(Crop crop);
	
Crop find(int cropId);
	
	List<Crop> load();
	
	void remove(int cropId);
	
	void edit(Crop crop);

}
