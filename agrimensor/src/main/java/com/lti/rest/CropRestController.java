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

	import com.lti.entity.Bidder;
	import com.lti.entity.Crop;
	import com.lti.entity.Farmer;
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
		
		/*@GetMapping(value = "/fetchCrop", produces = "application/json")
		public List<Crop> fetchCropByBidder(@RequestParam("bidderId") int bidderId) {
			return CropService.loadCropofBidder(bidderId);
			
		}*/
		@GetMapping(value = "/fetchCrop", produces = "application/json")
		public List<Crop> fetchCropByBidder(@RequestParam("bidderId") int bidderId) {
			Bidder b1= BidderService.find(bidderId);
			List<Crop> crop=b1.getCrop();
			return crop;
		}
		//Fetching through named query
		/*
		 * @GetMapping(value = "/fetchCrop", produces = "application/json") public
		 * List<Crop> fetchCropOfBider(){ return CropService.loadofCrop(); }
		 */

}
