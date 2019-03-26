package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.ObservedFlower;

@Service
@Repository
public interface ObservedFlowerRepository extends MongoRepository<ObservedFlower ,String>{

	
	ObservedFlower findObservedFlowerById(String id);

	List<ObservedFlower> findObservedFlowerByIdApiary(String idApiary);
	 

}
