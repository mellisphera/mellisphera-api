package com.mellisphera.repositories;

import com.mellisphera.entities.Swarm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SwarmRepository extends MongoRepository<Swarm, String> {

}
