package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.DailyStockMiel;

@Service
@Repository
public interface DailyStockMielRepository extends MongoRepository<DailyStockMiel ,String>{

}
