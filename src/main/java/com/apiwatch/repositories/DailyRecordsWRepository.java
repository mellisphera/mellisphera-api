package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.DailyRecordsW;

@Service
@Repository
public interface DailyRecordsWRepository extends MongoRepository<DailyRecordsW ,String>{
	
	DailyRecordsW findByIdHive(String id);
	
	List<DailyRecordsW> findDailyRecordsWByIdHive(String idHive);
	
}
