package com.wipro.velocity.efarm.controller;

import java.util.List;
import java.util.Optional;

import com.wipro.velocity.efarm.exception.ResourceNotFoundException;
import com.wipro.velocity.efarm.model.Crop;

import com.wipro.velocity.efarm.repository.CropRepo;
import com.wipro.velocity.efarm.status.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crop")
@CrossOrigin
public class CropController {
	
	@Autowired
	CropRepo cropRepo; 
	
	@PostMapping("/register")
	public Status saveCell(@Validated @RequestBody Crop cell)
	{
		Status s=new Status();
		Crop crop= new Crop();
		crop.setCropName(cell.getCropName());
		crop.setCropType(cell.getCropType());
		crop.setFertilizerType(cell.getFertilizerType());
		crop.setQuantity(cell.getQuantity());
		crop.setPrice(cell.getPrice());
		crop.setSoilpH(cell.getSoilpH());
		cropRepo.save(crop);
		s.setMessage("Crop Registered Successfully");
		return s;

}
	
	@GetMapping("/crops")
	public List<Crop> getAllCrops()
	{
		return cropRepo.findAll();
	}
	
	@PostMapping("/updatebid/{amount}")
	public Status setBidAmount(@PathVariable(value = "amount")  String amount )
	{
		Status s=new Status();
		Optional<Crop> crop=cropRepo.findById("62e246e5f10fee3c529c08ef");
		Crop c=crop.get();
		c.setPrice(amount);
		cropRepo.save(c);
	s.setMessage("Successfully updated");
		return s;
	}
	
//	@PutMapping("/updatebid/{id}")
//public ResponseEntity<Crop> updateCrop(@PathVariable(value = "id") String id,
//		@Validated @RequestBody Crop c) throws ResourceNotFoundException
//{
//	Crop crop=cropRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException
//			("Crop Not found for this id: "+id));
		
//	crop.setPrice(c.getPrice());
//final Crop updatedCrop=cropRepo.save(crop);
//	return ResponseEntity.ok(updatedCrop);
				
//}
}
