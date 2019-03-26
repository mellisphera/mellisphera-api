package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.FlowerINRA;


@Service
@Repository
public interface FlowerINRARepository extends MongoRepository<FlowerINRA,String>{

}
