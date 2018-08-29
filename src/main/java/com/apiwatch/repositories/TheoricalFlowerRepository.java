package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.TheoricalFlower;


@Service
@Repository
public interface TheoricalFlowerRepository extends MongoRepository<TheoricalFlower,String>{

	
}