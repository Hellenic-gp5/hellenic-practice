package com.lti.service;




import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Insurance;
import com.lti.entity.InsuranceClaim;
import com.lti.repo.InsuranceRepo;
/**
 * @author YOJAN java version 1.8
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	private InsuranceRepo repo;
	@Transactional(value = TxType.REQUIRED)
	@Override
	public void Apply(Insurance ins) {
		// TODO Auto-generated method stub
		repo.Save(ins);
	}

	@Override
	public Insurance search(int polid) {
		// TODO Auto-generated method stub
		return repo.fetch(polid);
	}

	
	@Transactional(value = TxType.REQUIRED)
	@Override
	public void action(String status, int polid) {
		// TODO Auto-generated method stub
		repo.update(status, polid);
	}
	@Transactional(value = TxType.REQUIRED)
	@Override
	public void addClaim(int polid, InsuranceClaim claim) {
		// TODO Auto-generated method stub
		repo.claim(polid, claim);
		
	}

	
	
	
}
