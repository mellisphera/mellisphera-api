package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Connection;

@Service
@Repository
public interface ConnectionRepository  extends MongoRepository<Connection ,String> {
	
}
