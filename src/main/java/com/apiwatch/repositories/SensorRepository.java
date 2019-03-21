package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Sensor;

@Service
@Repository
public interface SensorRepository extends MongoRepository<Sensor,String>{

	List<Sensor> findSensorByUsername(String username);
	List<Sensor> findSensorByIdHive(String idHive);
	Sensor findSensorById(String id);
	Sensor findSensorsByReference(String reference);
	
}
