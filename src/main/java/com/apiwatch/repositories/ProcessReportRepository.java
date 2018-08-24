package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Post;
import com.apiwatch.entities.ProcessReport;



@Service
@Repository
public interface ProcessReportRepository extends MongoRepository<ProcessReport,String> {

	List<ProcessReport> findProcessReportByIdApiary(String idApiary);
	
	List<ProcessReport> findProcessReportByIdHive(String idAHive);
}
