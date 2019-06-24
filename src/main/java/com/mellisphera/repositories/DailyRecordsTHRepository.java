package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.DailyRecordsTH;
import com.mellisphera.entities.Record;

@Service
@Repository
public interface DailyRecordsTHRepository extends MongoRepository<DailyRecordsTH ,String>{
	
	List<DailyRecordsTH> findDailyRecordsTHByIdHive(String idHive);
	
	//DailyRecordsTH findDailyRecordsTHByrecordDate(Date date);
	List<DailyRecordsTH> findOneLastDailyRecordsTHByIdHive(String idHive);
	
    List<DailyRecordsTH> findByIdHiveAndRecordDateBetween(String idHive, Date start, Date end, Sort sort);

}
