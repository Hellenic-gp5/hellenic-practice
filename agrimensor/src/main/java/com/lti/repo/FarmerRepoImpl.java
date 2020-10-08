package com.lti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.entity.User;

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
		//em.persist(insurance);
		em.merge(farmer);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void addCrop(int farmerId, Crop crop) {
		Farmer farmer=em.find(Farmer.class,farmerId);
		farmer.getCrops().add(crop);
		em.persist(crop);
		em.merge(farmer);
	}
	//changing status of Farmer

	/*
	 * @Override
	 * 
	 * @Transactional(value = TxType.REQUIRED) public void updateFarmerStatus(int
	 * farmerId, String farmerStatus) { Farmer farmer = em.find(Farmer.class,
	 * farmerId); farmer.setFarmerStatus(farmerStatus); em.merge(farmer);
	 * 
	 * }
	 */

//	@Override
//	public Number countFarmer() {
//		 return ((Number)em.createQuery("SELECT count(f) From Farmer f").getSingleResult()).intValue();
//			
//	}

	@Override
	public List<Crop> getAllCrops() {
		/*
		 * return em.
		 * createNativeQuery("Select cropName, cropType, cropId From Crop where cropId in (Select cropId from farmer_crop)"
		 * ).getResultList();
		 */
		Query q=em.createQuery("From Crop");
		List<Crop> users= q.getResultList();
		return users;
	}

	@Override
	public List<Policies> getinsurance(int farmerid) {
		// TODO Auto-generated method stub
		Query q= em.createNativeQuery("select policyid, policycompany,policycroparea,season,policysharedpremium from "
				+ "insurance where policyid in (select insurance_policyid from farmer_insurance where farmer_farmerid=:fid)");
		q.setParameter("fid",farmerid);
		List<Object[]> policies=q.getResultList();
		List<Policies> insurance=new ArrayList<Policies>();
		for(Object[] c: policies)
		{ Policies p= new Policies();
			p.setPolicyId((Number)c[0]);
			p.setPolicyCompany((String)c[1]);
			p.setPolicyCropArea((Number)c[2]);
			p.setSeason((String)c[3]);
			p.setPolicySharedPremium((Number)c[4]);
			insurance.add(p);
		}
		return insurance;
	}

	
}
