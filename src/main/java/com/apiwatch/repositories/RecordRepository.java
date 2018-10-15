package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.Record;
import java.util.List;

public interface RecordRepository  extends MongoRepository<Record,String> {
    
    public List<Record> findRecordByIdHive(String idHive);

}
