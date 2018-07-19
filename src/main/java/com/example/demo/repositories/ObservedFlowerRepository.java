package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ObservedFlower;

@Service
@Repository
public interface ObservedFlowerRepository extends MongoRepository<ObservedFlower ,String>{


}
