package com.lti.repo;

import java.util.List;


import com.lti.entity.Crop;

public interface CropRepo {
	
	void save(Crop crop);
	Crop fetch(int cropId);
	List<Crop> list();
	
	void delete(int cropId);
	void update(Crop crop);

}
