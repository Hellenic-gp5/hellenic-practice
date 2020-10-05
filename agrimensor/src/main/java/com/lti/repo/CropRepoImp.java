package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.entity.Crop;
/**
* 
* @author Sakshi
*
*/

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
	/**
	* method for getting all crop listed with a particular bidder
	* 
	* @author Sakshi
	*
	*/
	public List<Crop> listofCrop( int bidderId){
		Query q1= em.createNativeQuery("Select cropId, cropName, cropType, cropBasePrice FROM Crop WHERE cropId IN(SELECT cropId FROM bidder_crop WHERE bidderId=:bidderId)");
			q1.setParameter("bidderId", bidderId);
			return q1.getResultList();
	}

	/**
	* method for getting all the bids of a particular crop
	* 
	* @author Ruhi
	*
	*/
		public List<Bid> listOfBidsByCropId(Crop id) {
			Query q1 = em.createNamedQuery("getBidsByCropId");
			q1.setParameter("cropId", id);
			return q1.getResultList();
		}
		
		
		
}
