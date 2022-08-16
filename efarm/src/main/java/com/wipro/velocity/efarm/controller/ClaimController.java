package com.wipro.velocity.efarm.controller;

import java.util.List;

import com.wipro.velocity.efarm.model.Claim;
import com.wipro.velocity.efarm.model.Policy;
import com.wipro.velocity.efarm.repository.ClaimRepo;
import com.wipro.velocity.efarm.repository.PolicyRepo;
import com.wipro.velocity.efarm.status.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
@CrossOrigin
public class ClaimController {
	
	@Autowired
	ClaimRepo claimRepo;
	
	@Autowired
	PolicyRepo policyRepo;
	
	@PostMapping("/claim")
	public Status saveUser3(@Validated @RequestBody Claim user3)
	{
		Status s=new Status();
		Claim claim = new Claim();
		claim.setPolicyNo(user3.getPolicyNo());
		claim.setCompany(user3.getCompany());
		claim.setName(user3.getName());
		claim.setSumInsured(user3.getSumInsured());
		claim.setCause(user3.getCause());
		claim.setDate(user3.getDate());
		claimRepo.save(claim);
		s.setMessage(" Success");
		return s;

}
	@PostMapping("/policy")
	public Status saveUser4(@Validated @RequestBody Policy user4)
	{
		Status s=new Status();
		Policy policy = new Policy();
		policy.setSeason(user4.getSeason());
		policy.setYear(user4.getYear());
		policy.setCrop(user4.getCrop());
		policy.setSumInsured(user4.getSumInsured());
		policy.setArea(user4.getArea());
		policyRepo.save(policy);
		s.setMessage(" Success");
		return s;

}
	@GetMapping("/policy")
	public List<Policy> getAllPolicy()
	{
		return policyRepo.findAll();
	}
}