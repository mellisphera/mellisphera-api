package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;

@Service
@Repository
public interface HivesRepository  extends MongoRepository<Hive ,String>{

	
	List<Hive> findHiveByUsername(String username);

	List<Hive> findHiveByuserId(String userId);
	
	List<Hive> findHiveByApiaryId(String apiaryId);

}