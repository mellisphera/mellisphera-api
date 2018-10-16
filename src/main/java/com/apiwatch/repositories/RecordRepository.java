package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.Record;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface RecordRepository  extends MongoRepository<Record,String> {
    
    public List<Record> findRecordByIdHive(String idHive, Sort sort);

}
