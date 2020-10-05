package com.lti.rest;

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
	
	@PostMapping(value = "/addfarmer", consumes = "application/json")
	public String addFarmer(@RequestBody Farmer farmer) {
		service.persist(farmer);
		return "Farmer added successfully";
	}
	
	@PostMapping(value="/apply/{fid}", consumes="application/json")
	public String apply(@PathVariable int fid, @RequestBody Insurance insurance) {
		service.insure(fid, insurance);
		return "insurance added successfully";
	}
	
	@GetMapping(value = "/fetchfarmer", produces = "application/json")
	public Farmer fetchFarmer(@RequestParam("farmerId") int farmerId) {
		return service.find(farmerId);
	}
	
	@PostMapping(value = "/addcrop", consumes = "application/json")
	public String addCrop(@RequestBody Crop crop) {
		service.Add(crop);
		return "Crop added successfully";
	}
	
//	@GetMapping(value = "/listfarmer", produces = "application/json")
//	public List<Farmer> listFarmer(){
//		return service.load();
//	}
//	
//	@PutMapping(value = "/editfarmer", consumes = "application/json")
//	public String updateFarmer(@RequestBody Farmer farmer) {
//		service.edit(farmer);
//		return "Farmer updated successfully";
//	}
//	
//	@DeleteMapping("/delfarmer")
//	public String delEmployee(@RequestParam("farmerId") int farmerId) {
//		service.remove(farmerId);
//		return "Farmer deleted successfully";
//	}
	
	
}
