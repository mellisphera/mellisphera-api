package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Flower;
import com.example.demo.entities.FlowerTest;


@Service
@Repository
public interface FlowerTestRepository extends MongoRepository<FlowerTest,String>{

}