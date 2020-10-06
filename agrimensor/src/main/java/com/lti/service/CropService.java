package com.lti.service;

import java.util.List;

import com.lti.entity.Bid;
import com.lti.entity.Crop;

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

	List<Bid> listOfBids(int cropId);
	
	Number countSoldCrops();
}
