package com.apiwatch.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.DailyRecordsTH;

@Service
@Repository
public interface DailyRecordsTHRepository extends MongoRepository<DailyRecordsTH ,String>{
	
	List<DailyRecordsTH> findDailyRecordsTHByIdHive(String idHive);
	
	//DailyRecordsTH findDailyRecordsTHByrecordDate(Date date);
	List<DailyRecordsTH> findOneLastDailyRecordsTHByIdHive(String idHive);
}
