package com.lti.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Crop;
import com.lti.repo.CropRepo;


@Service
public class CropServiceImp implements CropService {
	
	@Autowired
	private CropRepo repo;

	public void persist(Crop crop) {
		repo.save(crop);
		

	}

	public Crop find(int cropId) {
		return repo.fetch(cropId);
	}

	public List<Crop> load() {
		return repo.list();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void remove(int cropId) {
		repo.delete(cropId);

	}
	
	@Transactional(value = TxType.REQUIRED)
	public void edit(Crop crop) {
		repo.update(crop);

	}

}
