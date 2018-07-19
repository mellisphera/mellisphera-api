package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Flower;

public interface TheoricalFlowerRepository extends MongoRepository<Flower,String>{ 

}
