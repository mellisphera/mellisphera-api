package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Sensor;

@Service
@Repository
public interface SensorRepository extends MongoRepository<Sensor,String>{

}
