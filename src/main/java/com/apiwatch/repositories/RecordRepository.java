package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.Record;

public interface RecordRepository  extends MongoRepository<Record,String> {

}
