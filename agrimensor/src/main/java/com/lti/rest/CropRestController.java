package com.lti.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.repo.CropBid;
import com.lti.repo.CropRepo;
import com.lti.repo.HistCrops;
import com.lti.repo.ReturnCrop;
import com.lti.service.CropService;
import com.lti.service.BidderService;
import com.lti.service.FarmerService;

@CrossOrigin
@RestController
public class CropRestController {

	@Autowired
	private CropService CropService;

	@Autowired
	private BidderService BidderService;
	@Autowired
	private CropRepo repo;

	/*
	 * @GetMapping(value = "/fetchCrop", produces = "application/json") public
	 * List<Crop> fetchCropByBidder(@RequestParam("bidderId") int bidderId) { return
	 * CropService.loadCropofBidder(bidderId);
	 * 
	 * }
	 */
	@GetMapping(value = "/fetchCrop", produces = "application/json")
	public List<Crop> fetchCropByBidder(@RequestParam("bidderId") int bidderId) {
		Bidder b1 = BidderService.find(bidderId);
		List<Crop> crop = b1.getCrop();
		return crop;
	}

	@GetMapping(value = "/listbidsOnCrop", produces = "application/json")
	public List<CropBid> listbid(@RequestParam int cropId) {
		return CropService.listOfBids(cropId);
	}

	@GetMapping(value = "/updateCropStatus")
	public String updateSoldStatus(@RequestParam String cropSoldStatus, @RequestParam int cropId) {
		CropService.updateCropSoldStatus(cropId, cropSoldStatus);
		return "Status changed successfully to " + cropSoldStatus;
	}
	
	//methods for admin-dashboard
	
	@GetMapping(value = "/soldcrops", produces = "application/json")
	public Number getSoldCrops() {
		return CropService.countSoldCrops();
	}
	@GetMapping(value = "/allcrops", produces = "application/json")
	public Number getAllCrops() {
		return CropService.countAllCrops();
	}
	@GetMapping(value = "/unsoldcrops", produces = "application/json")
	public Number getUnsoldCrops() {
		return CropService.countUnsoldCrops();
	}
	
	@GetMapping(value="/marketcrops", produces="application/json")
	public List<Crop> activeCrops(){
		List<Crop> crops= CropService.Active();
		for(Crop c:crops)
			c.setCurrentBid(CropService.currentBid(c.getCropId()));
		return crops;
	}
	@GetMapping(value="/getAllCrops", produces = "application/json")
	public List<ReturnCrop> getCrops(){
		return repo.crops();
		
	}
	
//	@GetMapping(value="/maxbid")
//	public Number curbid(@RequestParam int cropid) {
//		return CropService.currentBid(cropid);
//	}
	
	@GetMapping(value="/sale",produces="application/json")
	public List<HistCrops> sellCrops(@RequestParam("farmerId")int farmerId){
		List<HistCrops> crop= CropService.sale(farmerId);
//		for(Crop c:crop)
//			System.out.println(c);
		return crop;
		
		
	}
}
