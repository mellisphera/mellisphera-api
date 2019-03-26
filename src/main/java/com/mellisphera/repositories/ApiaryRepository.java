package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Apiary;

@Service
@Repository
public interface ApiaryRepository  extends MongoRepository<Apiary ,String>{
	
	List<Apiary> findApiaryByUsername(String username);
	
	Apiary findApiaryById(String id);
	
}

