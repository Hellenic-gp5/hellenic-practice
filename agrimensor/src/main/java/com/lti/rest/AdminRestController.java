package com.lti.rest;
/**
 * @author Ruhi
 * @version java 1.8
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bid;
import com.lti.repo.BidRepo;
import com.lti.service.BidService;

@CrossOrigin
@RestController
public class AdminRestController {

	@Autowired
	private BidRepo repo;
	
	@GetMapping(value = "/currentBid/{cropId}", produces = "application/json")
	public Bid getCurrentBid(@PathVariable int cropId) {
		return repo.fetchCurrentBid(cropId);
	}
}
