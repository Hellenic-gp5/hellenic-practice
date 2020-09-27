package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.service.BidService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.lti.entity.Bid;

@CrossOrigin
@RestController
public class BidRestController {

	@Autowired
	private BidService service;

	@PostMapping(value = "/addBid", consumes = "application/json")
	public String addBid(@RequestBody Bid bid) {
		service.persistBid(bid);
		return "Bid added successfully";
	}

	@GetMapping(value = "/fetchBid", produces = "application/json")
	public Bid fetchBid(@RequestParam("bidId") int bidId) {
		return service.findBid(bidId);
	}

	@GetMapping(value = "/listBid", produces = "application/json")
	public List<Bid> listBid() {
		return service.loadBid();
	}

	@PutMapping(value = "/editBid", consumes = "application/json")
	public String editBid(@RequestBody Bid bid) {
		service.updateBid(bid);
		return "Bid updated successfully";
	}

	@DeleteMapping("/delBid")
	public String delBid(@RequestParam("bidId") int bidId) {
		service.removeBid(bidId);
		return "Bid deleted successfully";
	}
	@PutMapping(value = "/updateBidStatus/{bidId}{bidStatus}", consumes = "application/json")
	public String updateBidStatus(@PathVariable int bidId, String bidStatus) {
		service.updateBidStatus(bidId, bidStatus);
		return "Bid updated successfully";
	}

}
