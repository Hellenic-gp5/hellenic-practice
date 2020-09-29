package com.lti.repo;



import java.util.List;

import com.lti.entity.Insurance;



/**
 * @author YOJAN java version 1.8
 *
 */
public interface InsuranceRepo {
	void Save(Insurance ins);
	
	Insurance fetch(int polid);
	
	List<Insurance> list();
	
	void update(String status, int polid);
	
		
}
