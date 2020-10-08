package com.lti.service;

import java.util.List;

import com.lti.entity.Bid;
import com.lti.entity.Crop;
import com.lti.repo.CropBid;
import com.lti.repo.HistCrops;
import com.lti.repo.Market;
import com.lti.repo.ReturnCrop;

/**
 * @author Sakshi
 *
 */
public interface CropService {
	
void persist(Crop crop);
	
Crop find(int cropId);
	
	List<Crop> load();
	
	void remove(int cropId);
	
	void edit(Crop crop);
	
	void updateCropSoldStatus(int cropId,String cropSoldStatus);
	List<Crop> loadofCrop(int bidderId);

	List<CropBid> listOfBids(int cropId);
	
	Number countSoldCrops();
	
	Number countAllCrops();
	
	Number countUnsoldCrops();
	
	List<Crop> Active();
	
	Number currentBid(int cropid);
	
	List<HistCrops> sale(int farmerId);
	
	List<ReturnCrop> crops();
	
	List<Market> market();
}
