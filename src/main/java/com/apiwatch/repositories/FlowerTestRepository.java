package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Flower;
import com.apiwatch.entities.FlowerTest;


@Service
@Repository
public interface FlowerTestRepository extends MongoRepository<FlowerTest,String>{

}