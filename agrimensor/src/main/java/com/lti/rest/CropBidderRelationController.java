package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.service.BidderService;
import com.lti.service.CropService;

/**
 * @author Sakshi
 * Bidder-crop relation controller class
 *
 */
@CrossOrigin
@RestController
public class CropBidderRelationController {
	@Autowired
	private CropService CropService;
	
	@Autowired
	private BidderService BidderService;
	
	
	
	@PostMapping(value= "/saveCropOfBidder")
	public void testAddBidderCrop(@RequestParam("bidderId") int bidderId,
			@RequestParam("cropId") int cropId) {
		Bidder b1= BidderService.find(bidderId);
		BidderService.persistBidderCrop(b1, cropId);
		
		}
	@GetMapping(value = "/fetchCrop", produces = "application/json")
	public List<Crop> fetchCropByBidder(@RequestParam("bidderId") int bidderId){
		return CropService.loadofCrop(bidderId);
	}

	

}
