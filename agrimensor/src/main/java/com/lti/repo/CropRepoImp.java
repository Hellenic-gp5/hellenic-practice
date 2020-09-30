package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;

@Repository
public class CropRepoImp implements CropRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void saveCrop(Crop crop) {
		em.persist(crop);

	}

	public Crop fetchCropById(int cropId) {
		Crop c=em.find(Crop.class, cropId);
		return c;
	}

	public List<Crop> listCrop() {
		return em.createQuery("from Crop").getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteCrop(int cropId) {
		em.remove(em.find(Crop.class, cropId));	
		

	}
	@Transactional(value = TxType.REQUIRED)
	public void updateCrop(Crop crop) {
		em.merge(crop);

	}
	
	@Transactional(value = TxType.REQUIRED)
	public void updateCropSoldStatus(int cropId, String cropSoldStatus) {
		em.createQuery("UPDATE Crop c SET c.cropSoldStatus= :cropSoldStatus " + "WHERE c.cropId = :cropId");
		
	}

}
