package com.mellisphera.repositories;

import com.mellisphera.entities.AlertUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertUserRepository extends MongoRepository<AlertUser, String> {

    public AlertUser findByUserId(String userId);
}
