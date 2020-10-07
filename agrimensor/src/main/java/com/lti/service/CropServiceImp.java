package com.lti.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Bid;
import com.lti.entity.Crop;
import com.lti.repo.BidRepo;
import com.lti.repo.CropRepo;


/**
 * @author Sakshi
 *
 */
@Service
public class CropServiceImp implements CropService {
	
	@Autowired
	private CropRepo repo;

	public void persist(Crop crop) {
		repo.saveCrop(crop);
		

	}

	public Crop find(int cropId) {
		return repo.fetchCropById(cropId);
	}

	public List<Crop> load() {
		return repo.listCrop();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void remove(int cropId) {
		repo.deleteCrop(cropId);

	}
	
	@Transactional(value = TxType.REQUIRED)
	public void edit(Crop crop) {
		repo.updateCrop(crop);

	}
	
	public List<Crop> loadofCrop(int bidderId) {
		
		return repo.listofCrop(bidderId);
	}

	@Override
	public List<Bid> listOfBids(int cropId) {
		return repo.listOfBidsByCropId(cropId);
	}

	@Override
	public void updateCropSoldStatus(int cropId, String cropSoldStatus) {
		repo.updateCropSoldStatus(cropId, cropSoldStatus);
		
	}

	@Override
	public Number countSoldCrops() {
		
		return repo.countSoldCrop();
	}

	@Override
	public Number countAllCrops() {
		// TODO Auto-generated method stub
		return repo.countAllCrops();
	}

	@Override
	public Number countUnsoldCrops() {
		return repo.countUnsoldCrop();
	}

	@Override
	public List<Crop> Active() {
		// TODO Auto-generated method stub
		return repo.ActiveCrops();
	}

}
