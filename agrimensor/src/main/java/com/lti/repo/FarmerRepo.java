package com.lti.repo;

import java.util.List;

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;

/**
 * @author Anish
 *Methods to be implemented by farmer
 */
public interface FarmerRepo {
	
	void save(Farmer farmer);
	
	Farmer fetch(int farmerId);
	
	List<Farmer> list();
	
	void update(Farmer farmerId);
	
	void delete(int farmerId);
	
	void addInsurance(int farmerId, Insurance insurance);
	
	void addCrop(int farmerId, Crop crop);
}
