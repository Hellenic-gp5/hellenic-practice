package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;

/**
 * @author Anish
 * Implementation of the methods
 *
 */
@Repository
public class FarmerRepoImpl implements FarmerRepo {

	@PersistenceContext
	private EntityManager em;
	@Transactional(value = TxType.REQUIRED)
	public void save(Farmer farmer) {
		em.persist(farmer);

	}

	public Farmer fetch(int farmerId) {
		return em.find(Farmer.class, farmerId);
	}

	public List<Farmer> list() {
		return em.createQuery("from Farmer").getResultList();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(Farmer farmerId) {
		em.merge(farmerId);

	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(int farmerId) {
		em.remove(em.find(Farmer.class, farmerId));

	}
	
	@Transactional(value = TxType.REQUIRED)
	public void addInsurance(int farmerId, Insurance insurance) {
		Farmer farmer=em.find(Farmer.class,farmerId);
		farmer.getInsurance().add(insurance);
		em.persist(insurance);
		em.merge(farmer);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void addCrop(int farmerId, Crop crop) {
		Farmer farmer=em.find(Farmer.class,farmerId);
		farmer.getCrops().add(crop);
		em.persist(crop);
		em.merge(farmer);
	}

}
