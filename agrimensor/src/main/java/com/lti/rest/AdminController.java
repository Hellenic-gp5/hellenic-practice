package com.lti.rest;
/**
 * @author Ruhi
 * @version java 1.8
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.entity.Bid;
import com.lti.entity.Count;
import com.lti.entity.User;
import com.lti.repo.AdminRepo;
import com.lti.repo.BidRepo;
import com.lti.repo.Counts;
import com.lti.repo.UserRepo;
import com.lti.service.AdminService;
import com.lti.service.BidService;
import com.lti.service.BidderService;
import com.lti.service.FarmerService;
//updating the status for updating the statuses of all the users
@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	private AdminService aservice;
	@Autowired
	private BidRepo repo;
	
	@PostMapping(value="/addadmin",consumes="application/json")
	public String create(@RequestBody Admin admin) {
		aservice.createAdmin(admin);
		return "Admin added successfully";
	}
	
	@GetMapping(value="/approvallist",produces="application/json")
	public List<User> approval(){
		return aservice.approvals();
	}
	
	@GetMapping(value = "/currentBid/{cropId}", produces = "application/json")
	public Bid getCurrentBid(@PathVariable int cropId) {
		return repo.fetchCurrentBid(cropId);
	}
	/*
	 * @GetMapping(value="/bidderstatus/{bidderId}") public String
	 * updateBidder(@RequestParam String bidderStatus, @PathVariable int bidderId) {
	 * bidderService.updateBidderStatus(bidderId, bidderStatus); return
	 * "Status changed successfully to "+bidderStatus; }
	 */
	/*
	 * @GetMapping(value="/farmerstatus/{farmerId}") public String
	 * updateFarmer(@RequestParam String farmerStatus, @PathVariable int farmerId) {
	 * farmerService.updateFarmerStatus(farmerStatus, farmerId); return
	 * "Status changed successfully to "+farmerStatus; }
	 */
	/*
	 * @GetMapping(value="/userstatus/{userId}") public String updateU(@RequestParam
	 * String farmerStatus, @PathVariable int farmerId) {
	 * farmerService.updateFarmerStatus(farmerStatus, farmerId); return
	 * "Status changed successfully to "+farmerStatus; }
	 */
	 
		
}
