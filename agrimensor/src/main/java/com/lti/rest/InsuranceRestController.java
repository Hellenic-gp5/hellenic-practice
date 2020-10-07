package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Insurance;
import com.lti.entity.InsuranceClaim;
import com.lti.repo.InsuranceRepo;
import com.lti.service.InsuranceService;
import com.lti.service.InsuranceServiceImpl;

/**
 * @author YOJAN java version 1.8
 *
 */
@CrossOrigin
@RestController
public class InsuranceRestController {

	@Autowired
	private InsuranceService service;

	@Autowired
	private InsuranceRepo repo;
	
	@GetMapping(value = "/insurancestatus/{polid}")
	public String updateInsurance(@RequestParam String status, @PathVariable int polid) {
		service.action(status, polid);
		return "Status changed successfully to " + status;
	}

	@GetMapping(value = "/fetchpolicy", produces = "application/json")
	public Insurance FetchPolicy(@RequestParam int id) {
		return service.search(id);
	}

	@PostMapping(value = "/applyclaim", consumes = "application/json")
	public String claim(@RequestParam int polid, @RequestBody InsuranceClaim cl) {
		service.addClaim(polid, cl);
		return "Claim applied successfully";
	}
	// methods for admin-dashboard

	@GetMapping(value = "/pendinginsurances", produces = "application/json")
	public Number getAllInsurances() {
		return service.countPendingInsurances();
	}

	@GetMapping(value = "/rejectedinsure", produces = "application/json")
	public Number getRejectedInsurances() {
		return service.countRejectedInsurance();
	}

	@GetMapping(value = "/approvedinsure", produces = "application/json")
	public Number getApprovedInsure() {
		return service.countApprovedInsurances();
	}
	
	@GetMapping(value = "/getclaims", produces="application/json")
	public List<InsuranceClaim> claims(){
		return repo.getClaims();
	}
}
