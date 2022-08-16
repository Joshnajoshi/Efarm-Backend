package com.wipro.velocity.efarm.repository;

import com.wipro.velocity.efarm.model.Bidder;
import com.wipro.velocity.efarm.model.Farmer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidderRepo extends MongoRepository<Bidder, String> {

	Farmer findByEmail(String email);

}
