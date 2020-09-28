package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bid;
import com.lti.entity.Bidder;
import com.lti.service.BidderService;

@CrossOrigin
@RestController
public class BidderRestController {
	
	@Autowired
	private BidderService service;
	
	@PostMapping(value = "/addBidder", consumes = "application/json")
	public String addBidder(@RequestBody Bidder bidder) {
		service.persist(bidder);
		return "Bidder added successfully";
	}
	@GetMapping(value = "/fetchBidder", produces = "application/json")
	public Bidder fetchBidder(@RequestParam("bidderId") int bidderId) {
		return service.find(bidderId);
	}
	@GetMapping(value = "/listBidder", produces = "application/json")
	public List<Bidder> listBid() {
		return service.load();
	}
	@PutMapping(value = "/editBidder", consumes = "application/json")
	public String editBidder(@RequestBody Bidder bidder) {
		service.edit(bidder);
		return "Bid updated successfully";
	}
	@DeleteMapping("/delBidder")
	public String delBidder(@RequestParam("bidderId") int bidderId) {
		service.remove(bidderId);
		return "Bid deleted successfully";
	}

}
