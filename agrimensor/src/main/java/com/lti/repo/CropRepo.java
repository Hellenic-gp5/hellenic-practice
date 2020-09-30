package com.lti.repo;

import java.util.List;


import com.lti.entity.Crop;

public interface CropRepo {
	
	void saveCrop(Crop crop);
	Crop fetchCropById(int cropId);
	List<Crop> listCrop();
	
	void deleteCrop(int cropId);
	void updateCrop(Crop crop);
	
	void updateCropSoldStatus(int cropId,String cropSoldStatus);

}
