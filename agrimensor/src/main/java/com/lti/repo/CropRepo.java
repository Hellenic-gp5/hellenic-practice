package com.lti.repo;

import java.util.List;

import com.lti.entity.Bid;
import com.lti.entity.Crop;

public interface CropRepo {
	
	void saveCrop(Crop crop);
	
	Crop fetchCropById(int cropId);
	
	List<Crop> listCrop();
	
	void deleteCrop(int cropId);
	
	void updateCrop(Crop crop);
	
	void updateCropSoldStatus(int cropId,String cropSoldStatus);
	
	List<CropBid> listOfBidsByCropId(int id);
	
	List<Crop> listofCrop(int bidderId);
	
	List<Crop>ActiveCrops();
	
	Number maxBid(int cropid);
	
	List<Crop> soldCrops(int farmerId);
	
	List<ReturnCrop> crops();

	List<Market> market();
}
