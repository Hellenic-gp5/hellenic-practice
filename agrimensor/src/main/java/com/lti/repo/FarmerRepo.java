package com.lti.repo;

import java.util.List;

import com.lti.entity.Farmer;

/**
 * @author Anish
 *Methods to be implemented
 */
public interface FarmerRepo {
	
	void save(Farmer farmer);
	
	Farmer fetch(int farmerId);
	
	List<Farmer> list();
	
	void update(Farmer farmerId);
	
	void delete(int farmerId);
}
