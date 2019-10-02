package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Sensor;

@Service
@Repository
public interface SensorRepository extends MongoRepository<Sensor,String>{

	List<Sensor> findSensorByUserId(String userId);
	List<Sensor> findSensorByHiveId(String hiveId);
	List<Sensor> findSensorByApiaryId(String apiaryId);
	Sensor findSensorsBySensorRef(String sensorRef);
	
}
