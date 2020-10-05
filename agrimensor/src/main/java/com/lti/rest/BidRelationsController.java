package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.service.BidService;

@CrossOrigin
@RestController
public class BidRelationsController {

	@Autowired
	private BidService service;
	
	/*
	 * @GetMapping(value = "/BidsOfBidder/{bidderId}", produces =
	 * "application/json") public List<Bid> fetchBid(@PathVariable int bidderId) {
	 * return service.bidsOfBidder(bidderId); }
	 */
	@PutMapping(value = "/addBids", consumes = "application/json")
	public String addBidsForBidder(@RequestBody Bid bid) {
		service.persistBid(bid);
		return "Bid add for bidder "+bid.getBidderId();
	}
	/*
	 * @GetMapping(value = "/getBidsOnCrops/{cropId}", produces =
	 * "application/json") public List<Bid> getBidsOnCrops(@PathVariable int cropId)
	 * { return service.getBidsOnCrop(cropId);
	 * 
	 * }
	 */

}
