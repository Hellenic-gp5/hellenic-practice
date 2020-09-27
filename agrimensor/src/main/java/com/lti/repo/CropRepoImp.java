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

	public void save(Crop crop) {
		em.persist(crop);

	}

	public Crop fetch(int cropId) {
		Crop c=em.find(Crop.class, cropId);
		return c;
	}

	public List<Crop> list() {
		return em.createQuery("from Crop").getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(int cropId) {
		em.remove(em.find(Crop.class, cropId));	
		

	}
	@Transactional(value = TxType.REQUIRED)
	public void update(Crop crop) {
		em.merge(crop);

	}

}
