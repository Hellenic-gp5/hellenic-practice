package com.lti.repo;

import java.util.List;

import com.lti.entity.Insurance;
import com.lti.entity.InsuranceClaim;

/**
 * @author YOJAN java version 1.8
 *
 */
public interface InsuranceRepo {
	void Save(Insurance ins);

	Insurance fetch(int polid);

	void claim(int polid, InsuranceClaim claim);

	void update(String status, int polid);

	Number countRejectedInsurance();

	Number countApprovedInsurances();

	Number countPendingInsurances();

}
