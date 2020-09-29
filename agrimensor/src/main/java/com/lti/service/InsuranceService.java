package com.lti.service;

import java.util.List;

import com.lti.entity.Insurance;


/**
 * @author YOJAN java version 1.8
 *
 */
public interface InsuranceService {
void Apply(Insurance ins);
	
	Insurance search(int polid);
	
	List<Insurance> Show();
	
	void action(String status, int polid);
	
}
