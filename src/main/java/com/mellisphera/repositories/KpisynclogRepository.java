package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.Kpisynclog;

public interface KpisynclogRepository extends MongoRepository<Kpisynclog, String> {

}
