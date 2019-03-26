package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.ProcessReportTemp;

public interface ProcessReportTempRepository extends MongoRepository<ProcessReportTemp,String> {

	List<ProcessReportTemp> findProcessReportTempByUsername(String username);
	
}
