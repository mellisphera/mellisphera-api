package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Apiary;
import com.example.demo.entities.Hive;

@Service
@Repository
public interface HivesRepository  extends MongoRepository<Hive ,String>{

}