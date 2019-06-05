package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.Kpisynclog;

public interface KpisynclogRepository extends MongoRepository<Kpisynclog, String> {
	
	public List<Kpisynclog> findByDateBetween(Date start, Date end);

}
