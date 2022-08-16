package com.wipro.velocity.efarm.repository;

import com.wipro.velocity.efarm.model.Crop;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CropRepo extends MongoRepository<Crop, String> {


}
