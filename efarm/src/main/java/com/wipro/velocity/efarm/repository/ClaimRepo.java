package com.wipro.velocity.efarm.repository;

import com.wipro.velocity.efarm.model.Claim;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimRepo extends MongoRepository<Claim, String> {

}
