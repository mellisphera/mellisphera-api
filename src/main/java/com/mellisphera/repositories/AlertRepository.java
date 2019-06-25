package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mellisphera.entities.Alert;

public interface AlertRepository extends MongoRepository<Alert, String>{
	
	@Query("{ 'check' : false }")
	public List<Alert> findByIdApiary(String idApiary);
	
	@Query("{ 'check' : false }")
	public List<Alert> findByIdHive(String idHive);
}
