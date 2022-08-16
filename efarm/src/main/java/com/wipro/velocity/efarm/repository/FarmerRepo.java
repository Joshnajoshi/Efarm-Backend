package com.wipro.velocity.efarm.repository;

import com.wipro.velocity.efarm.model.Farmer;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface FarmerRepo extends MongoRepository<Farmer, String> {

	Farmer findByEmail(String email);

}
