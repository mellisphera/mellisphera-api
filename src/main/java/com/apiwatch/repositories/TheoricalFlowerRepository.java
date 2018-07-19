package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.Flower;

public interface TheoricalFlowerRepository extends MongoRepository<Flower,String>{ 

}
