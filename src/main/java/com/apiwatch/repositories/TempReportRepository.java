package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.ProcessReportTemp;



@Service
@Repository
public interface TempReportRepository  extends MongoRepository<ProcessReportTemp,String> {

}