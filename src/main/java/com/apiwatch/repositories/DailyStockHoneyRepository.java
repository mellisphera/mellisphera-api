package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.DailyStockHoney;
import java.util.List;
import org.springframework.data.domain.Sort;

@Service
@Repository
public interface DailyStockHoneyRepository extends MongoRepository<DailyStockHoney ,String>{

	public List<DailyStockHoney> findDailySrtockHoneyByIdApiary(String idApiary);
        
        public List<DailyStockHoney> findDailyStockHoneyByIdHive(String idHive);
	
}
