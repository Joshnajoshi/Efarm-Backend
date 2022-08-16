package com.wipro.velocity.efarm.controller;

import com.wipro.velocity.efarm.model.Bidder;
import com.wipro.velocity.efarm.model.Farmer;
import com.wipro.velocity.efarm.repository.BidderRepo;
import com.wipro.velocity.efarm.status.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bidder")
@CrossOrigin
public class BidderController {
	
	@Autowired
	private BidderRepo bidderRepo;
	
	@PostMapping("/register")
	public Status saveUser2(@RequestBody Bidder user)
	{
		Status s=new Status();
		Bidder bidder= new Bidder();
		bidder.setFullName(user.getFullName());
		bidder.setContactNo(user.getContactNo());
		bidder.setEmail(user.getEmail());
		bidder.setAddress1(user.getAddress1());
		bidder.setAddress2(user.getAddress2());
		bidder.setCity(user.getCity());
		bidder.setState(user.getState());
		bidder.setPincode(user.getPincode());
		bidder.setAadharNo(user.getAadharNo());
		bidder.setPanNo(user.getPanNo());
		bidder.setPassword(user.getPassword());
		bidderRepo.save(bidder);
		s.setMessage("Bidder Registered Successfully");
		return s;
	}
	
	@PostMapping("/bidderLogin")
    public Boolean loginUser( @RequestBody Bidder user) 
    {
        Boolean a=false;;
        String email=user.getEmail();
        String password=user.getPassword();
        System.out.println(email+password);
        Farmer b = bidderRepo.findByEmail(email);
        if(b==null) {
        	return a;
        }
        if(email.equals(b.getEmail()) && password.equals(b.getPassword()))
                {
            System.out.println(b.getEmail() +b.getPassword() );
            a=true;
           
                }
        return a;
    }

}

