package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.ShareApiary;

public interface ShareRepository extends MongoRepository<ShareApiary, String>{
	
	ShareApiary findShareHiveByidUsername(String idUser);
	
}
