package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.apiwatch.entities.TempReport;

public interface TempReportRepository  extends MongoRepository<TempReport,String> {

}
