package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Farmer;

/**
 * @author Anish
 *
 */
@Repository
public class FarmerRepoImpl implements FarmerRepo {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Farmer farmer) {
		em.persist(farmer);

	}

	public Farmer fetch(int farmerId) {
		return em.find(Farmer.class, farmerId);
	}

	public List<Farmer> list() {
		return em.createQuery("from Farmer").getResultList();
	}

	public void update(Farmer farmerId) {
		em.merge(farmerId);

	}

	public void delete(int farmerId) {
		em.remove(em.find(Farmer.class, farmerId));

	}

}
