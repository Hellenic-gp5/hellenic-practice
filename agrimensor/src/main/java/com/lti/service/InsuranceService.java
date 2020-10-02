package com.lti.service;

import java.util.List;

import com.lti.entity.Insurance;
import com.lti.entity.InsuranceClaim;


/**
 * @author YOJAN java version 1.8
 *
 */
public interface InsuranceService {
void Apply(Insurance ins);
	
	Insurance search(int polid);
	

	void action(String status, int polid);
	
	void addClaim(int polid, InsuranceClaim claim);
	
	
	
}
