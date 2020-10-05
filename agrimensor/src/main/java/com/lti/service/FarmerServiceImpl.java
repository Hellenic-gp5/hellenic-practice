package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.repo.CropRepo;
import com.lti.repo.FarmerRepo;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepo repo;

	@Autowired
	private CropRepo crepo;

	@Transactional(value = TxType.REQUIRED)
	public void persist(Farmer farmer) {
		repo.save(farmer);
	}

	public Farmer find(int farmerId) {
		return repo.fetch(farmerId);
	}

	public List<Farmer> load() {
		return repo.list();
	}

	@Transactional(value = TxType.REQUIRED)
	public void remove(int farmer) {
		repo.delete(farmer);
	}

	@Transactional(value = TxType.REQUIRED)
	public void edit(Farmer farmer) {
		repo.update(farmer);
	}

	@Override
	public void insure(int fid, Insurance insurance) {
		repo.addInsurance(fid, insurance);
	}

	@Transactional(value = TxType.REQUIRED)
	public void Add(Crop crop) {
		crepo.saveCrop(crop);
	}

	@Override
	public void updateFarmerStatus(String farmerStatus, int farmerId) {
		repo.updateFarmerStatus(farmerId, farmerStatus);
	}

}
