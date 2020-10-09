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

import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.Insurance;
import com.lti.repo.FarmerRepo;
import com.lti.repo.Policies;
import com.lti.service.FarmerService;
/**
 * 
 * @author Anish
 *
 */
@CrossOrigin
@RestController
public class FarmerRestController {
	
	@Autowired
	private FarmerService service;
	@Autowired
	private FarmerRepo repo;
	
	@PostMapping(value = "/addfarmer", consumes = "application/json")
	public String addFarmer(@RequestBody Farmer farmer) {
		farmer.setRole("Farmer");
		service.persist(farmer);
		return "Farmer added successfully";
	}
	
	@PostMapping(value="/apply", consumes="application/json")
	public void apply(@RequestParam("fid") int fid, @RequestBody Insurance insurance) {
		service.insure(fid, insurance);
	
	}
	
	@GetMapping(value = "/fetchfarmer", produces = "application/json")
	public Farmer fetchFarmer(@RequestParam("farmerId") int farmerId) {
		return service.find(farmerId);
	}
	
	@PostMapping(value = "/addcrop", consumes = "application/json")
	public String addCrop(@RequestParam("farmerId") int farmerId,@RequestBody Crop crop) {

		service.Add(farmerId,crop);
		return "Crop added successfully";
	}
	

	@GetMapping(value ="/listallcrops", produces="appplication/json")
		public List<Crop> getAllCrops(){
			return repo.getAllCrops();
		}
	@GetMapping(value="/listpolicies",produces="application/json")
		public List<Policies> getInsurances(@RequestParam("farmerId")int farmerid){
		return service.policies(farmerid);
	}
	
	
}
