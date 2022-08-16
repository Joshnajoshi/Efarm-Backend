package com.wipro.velocity.efarm.repository;

import com.wipro.velocity.efarm.model.Policy;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PolicyRepo extends MongoRepository<Policy, String> {

}
