package com.lti.rest;


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
	
	@GetMapping(value="/insurancestatus/{polid}")
	public String updateInsurance(@RequestParam String status, @PathVariable int polid) {
		service.action(status, polid);
		return "Status changed successfully to "+status;
	}

	@GetMapping(value="/fetchpolicy", produces="application/json")
	public Insurance FetchPolicy(@RequestParam int id)
	{ return service.search(id);}
	
	@PostMapping(value="/applyclaim/{polid}",consumes="application/json")
	public String claim(@PathVariable int polid, @RequestBody InsuranceClaim cl) {
		service.addClaim(polid, cl);
		return "Claim applied successfully";
	}
	
}