package com.mellisphera.repositories;

import com.mellisphera.entities.Alerts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository extends MongoRepository<Alerts, String> {


}
