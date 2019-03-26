package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.TheoricalFlower;


@Service
@Repository
public interface TheoricalFlowerRepository extends MongoRepository<TheoricalFlower,String>{

	
}