package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Connection;

@Service
@Repository
public interface ConnectionRepository  extends MongoRepository<Connection ,String> {
	
}
