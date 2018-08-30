package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.ProcessReportTemp;

public interface ProcessReportTempRepository extends MongoRepository<ProcessReportTemp,String> {

	List<ProcessReportTemp> findProcessReportTempByUsername(String username);
	
}
