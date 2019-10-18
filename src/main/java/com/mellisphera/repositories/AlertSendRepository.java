package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import com.mellisphera.entities.AlertSent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertSendRepository extends MongoRepository<AlertSent, String>{
	
	public List<AlertSent> findByIdApiary(String idApiary);
	
	public List<AlertSent> findByIdHive(String idHive);
	
	public List<AlertSent> findByIdHiveAndDateBetween(String idHive, Date start, Date end);
}
