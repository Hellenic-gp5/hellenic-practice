package com.lti.repo;

import java.util.ArrayList;
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
import com.lti.entity.Farmer;
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
		Crop crop = em.find(Crop.class, cropId);
		crop.setCropSoldStatus(cropSoldStatus);
		em.merge(crop);
		
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
		public List<CropBid> listOfBidsByCropId(int id) {
			Query q=em.createNativeQuery(" select b.bidder_bidderid,c.bidamount, c.bidid  from bidder_bids b join bids c on b.bids_bidid=c.bidid "
					+ "where c.bidid in (select bids_bidid from crop_bids where crop_cropid =:id) order by c.bidamount desc");
			q.setParameter("id", id);
			List<Object[]> items=q.getResultList();
			List<CropBid> bids=new ArrayList<CropBid>();
			for(Object[] c: items)
			{CropBid d=new CropBid();
			d.setBidAmount((Number)c[1]);
			d.setBidId((Number)c[2]);
			d.setBidderId((Number)c[0]);
			bids.add(d);
			}
			
			return bids;
		}
		


		@Override
		public List<ReturnCrop> crops() {
		Query q = em.createNativeQuery("select cropid, cropname, croptype, fertilizer, cropbaseprice, soilph from crop where cropsoldstatus='Queued'"  );
		List<Object[]> crop= q.getResultList();
		List<ReturnCrop> returnCrop=new ArrayList<ReturnCrop>();
		for (Object[] o: crop) {
			ReturnCrop r= new ReturnCrop();
			r.setCropId((Number)o[0]);
			r.setCropName((String)o[1]);
			r.setCropType((String)o[2]);
			r.setFertilizer((String)o[3]);
			r.setCropBasePrice((Number)o[4]);
			r.setSoilPH((String)o[5]);
			returnCrop.add(r);
		}
			return returnCrop;
		}
	@Override
	public Number countSoldCrop() {
		 return ((Number)em.createQuery("SELECT count(c) From Crop c WHERE c.cropSoldStatus='SOLD'").getSingleResult()).intValue();
	}

	@Override
	public Number countAllCrops() {
		 return ((Number)em.createQuery("SELECT count(u) From Crop u").getSingleResult()).intValue();
			
	}

	@Override
	public Number countUnsoldCrop() {
		 return ((Number)em.createQuery("SELECT count(c) From Crop c WHERE c.cropSoldStatus='Not Sold'").getSingleResult()).intValue();
		}

	@Override
	public List<Crop> ActiveCrops() {
		// TODO Auto-generated method stub
		List<Crop> crops=em.createQuery("FROM Crop WHERE cropSoldStatus = 'In Market'").getResultList();
		return crops;
	}

	@Override
	public Number maxBid(int cropid) {
		// TODO Auto-generated method stub
	Query q=	em.createNativeQuery(" select max(bidamount) from bids where bidid in (Select bids_bidid from crop_bids where crop_cropid=:id)");
		q.setParameter("id", cropid);
		return (Number)q.getSingleResult();
	}

	@Override
	public List<HistCrops> soldCrops(int farmerId) {
		// TODO Auto-generated method stub
		Query q= em.createNativeQuery("select * from crop where cropsoldstatus='Sold' and cropid in (select crops_cropid from farmer_crop where farmer_farmerid=:fid)");
		q.setParameter("fid", farmerId);
//		Farmer farmer= em.find(Farmer.class, farmerId);
//		List<Crop> crops=farmer.getCrops();
//		List<Crop> sold=new ArrayList<Crop>();
//		for(Crop c:crops) {
//			
//			if(c.getCropSoldStatus()=="Sold")
//			{sold.add(c);
//			System.out.println(c);
//			}
//		}
		
		List<Object[]> sold=q.getResultList();
		List<HistCrops> hist= new ArrayList<HistCrops>();
		for(Object[] c:sold) {
			HistCrops d=new HistCrops();
			d.setCropId((Number)c[0]);
			d.setCropBasePrice((Number)c[1]);
			d.setCropName((String)c[2]);
			d.setQuantity((Number)c[3]);
			d.setCropSoldPrice((Number)c[5]);
			d.setCropSoldStatus((String)c[6]);
			d.setCropType((String)c[7]);
			d.setFertilizer((String)c[8]);
			hist.add(d);			
		}
		return hist;
	}

	
		
}
