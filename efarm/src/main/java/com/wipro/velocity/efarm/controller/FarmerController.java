package com.wipro.velocity.efarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.efarm.model.Farmer;
import com.wipro.velocity.efarm.repository.FarmerRepo;
import com.wipro.velocity.efarm.status.Status;

@RestController
@RequestMapping("/farmer")
@CrossOrigin
public class FarmerController {
	
	@Autowired
	FarmerRepo farmerRepo;
	
	@PostMapping("/register")
	public Status saveUser(@Validated @RequestBody Farmer user)
	{
		Status s=new Status();
		Farmer farmer = new Farmer();
		farmer.setFullName(user.getFullName());
		farmer.setContactNo(user.getContactNo());
		farmer.setEmail(user.getEmail());
		farmer.setAddress1(user.getAddress1());
		farmer.setAddress2(user.getAddress2());
		farmer.setCity(user.getCity());
		farmer.setState(user.getState());
		farmer.setPincode(user.getPincode());
		farmer.setLandArea(user.getLandArea());
		farmer.setLandAddress(user.getLandAddress());
		farmer.setAccountNo(user.getAccountNo());
		farmer.setIfsc(user.getIfsc());
		farmer.setPassword(user.getPassword());
		farmerRepo.save(farmer);
		s.setMessage("farmer Registered Successfully");
		return s;
	}
	@PostMapping("/farmerLogin")
    public Boolean loginUser( @RequestBody Farmer user) 
    {
        Boolean a=false;;
        String email=user.getEmail();
        String password=user.getPassword();
        //System.out.println(email+password);
        Farmer b = farmerRepo.findByEmail(email);
        if(b==null) {
        	return a;
        }
        if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
                {
        //    System.out.println(d.getEmail() +d.getPassword() );
            a=true;
           
                }
        return a;
    }

}
