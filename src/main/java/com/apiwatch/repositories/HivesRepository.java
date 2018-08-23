package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;

@Service
@Repository
public interface HivesRepository  extends MongoRepository<Hive ,String>{

	
	List<Hive> findHiveByUsername(String username);
	
	List<Hive> findHiveByIdApiary(String idApiary);
		
	Hive findHiveById(String id);
	
}