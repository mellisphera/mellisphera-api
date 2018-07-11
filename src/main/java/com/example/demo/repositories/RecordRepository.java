package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Record;

public interface RecordRepository  extends MongoRepository<Record,String> {

}
