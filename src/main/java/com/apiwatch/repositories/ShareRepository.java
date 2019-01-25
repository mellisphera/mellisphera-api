package com.apiwatch.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.entities.ShareHive;

public interface ShareRepository extends MongoRepository<ShareHive, String>{
	
	ShareHive findShareHiveByidUsername(String idUser);
	
}
