package com.mellisphera.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.ShareApiary;

public interface ShareRepository extends MongoRepository<ShareApiary, String>{
	
	ShareApiary findShareHiveByidUsername(String idUser);
	
}
