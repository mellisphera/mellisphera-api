package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Post;
import com.mellisphera.entities.ProcessReport;



@Service
@Repository
public interface ProcessReportRepository extends MongoRepository<ProcessReport,String> {

	ProcessReport findProcessReportById(String id);
	
	List<ProcessReport> findProcessReportByIdApiary(String idApiary);
	
	List<ProcessReport> findProcessReportByIdHive(String idHive);
	
	List<ProcessReport> findProcessReportByIdLHive(String[] idLHive);
	
	List<ProcessReport> findProcessReportByIdLHive(String idHive);
}
