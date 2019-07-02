package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mellisphera.entities.Alert;

public interface AlertRepository extends MongoRepository<Alert, String>{
	
	public List<Alert> findByIdApiary(String idApiary);
	
	public List<Alert> findByIdHive(String idHive);
	
	@Query("{ 'loc' : 'Hive' }")
	public List<Alert> findAlertByidApiary(String idApiary);
}
